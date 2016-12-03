package com.framework.runtime.application;

import java.util.HashSet;
import java.util.Set;

import com.framework.runtime.application.util.IdWorker;

public class IdWorkerTest {
	 
    static class IdWorkThread implements Runnable {
        private Set<Long> set;
        private IdWorker idWorker;
 
        public IdWorkThread(Set<Long> set, IdWorker idWorker) {
            this.set = set;
            this.idWorker = idWorker;
        }
        static long num = 0;
        @Override
        public void run() {
            while (true) {
                long id = idWorker.nextId();
                if (!set.add(id)) {
                    System.out.println("duplicate:" + id);
                }
	                
//                System.out.println(id);
            }
        }
    }
 
    public static void main(String[] args) {
        Set<Long> set = new HashSet<Long>();
        set.add(1L);
        set.add(1L);
        set.add(1L);
        set.add(1L);
        System.out.println(set.size());
        final IdWorker idWorker1 = new IdWorker(0, 0);
        final IdWorker idWorker2 = new IdWorker(1, 0);
        Thread t1 = new Thread(new IdWorkThread(set, idWorker1));
        Thread t2 = new Thread(new IdWorkThread(set, idWorker2));
        t1.setDaemon(true);
        t2.setDaemon(true);
        t1.start();
        t2.start();
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
