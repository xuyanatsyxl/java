/*
 * jPOS Project [http://jpos.org]
 * Copyright (C) 2000-2013 Alejandro P. Revilla
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.jpos.iso;


/**
 * MUX interface
 * @author Alejandro Revilla
 * @version $Revision$ $Date$
 */
public interface MUX {
    /**
     * @param m message to send
     * @param timeout time to wait for a message
     * @return received message or null
     * @throws ISOException
     */
    public ISOMsg request (ISOMsg m, long timeout) throws ISOException;

    public void request (ISOMsg m, long timeout, ISOResponseListener r, Object handBack)
        throws ISOException;

    /**
     * @return true if connected
     */
    public boolean isConnected();
}

