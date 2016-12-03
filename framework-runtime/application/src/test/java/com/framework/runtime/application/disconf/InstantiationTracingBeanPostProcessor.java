package com.framework.runtime.application.disconf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * spring初始化结束后,执行
 *
 * @author wenjl
 */
@Configuration
public class InstantiationTracingBeanPostProcessor implements ApplicationListener<ContextRefreshedEvent> {
    protected static final Logger LOGGER = LoggerFactory
            .getLogger(InstantiationTracingBeanPostProcessor.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (event.getApplicationContext().getParent() == null)//root applicationContext没有parent，保证是统一的context
        {
            LOGGER.info("init thread...");
            new Thread(new DisconfDemoTask(simpleConfig)).start();

            while (true) {

                LOGGER.info("auto service : {} ", autoService.getAuto());

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                }
            }

        }
    }

    @Autowired
    private SimpleConfig simpleConfig;

    @Autowired
    private AutoService autoService;
}
