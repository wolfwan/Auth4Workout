/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.io.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.net.*;

/**
 *
 * @author wwanless
 */
public class SocketListenerTest {

    public SocketListenerTest() {
    }

    @Test
    public void testFailAuthServer() throws Exception {
        
        SocketListener testSocket = new SocketListener();
        InetAddress address = InetAddress.getLocalHost();

        Socket socket = new Socket(address, 8000);


        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

        oos.writeObject("heloooo/wurld");

        boolean isvalid = (Boolean) ois.readObject();
        assertFalse(isvalid);



    }

    @Test
    public void testPassAuthServer() throws Exception {
        
        SocketListener testSocket = new SocketListener();
        InetAddress address = InetAddress.getLocalHost();

        Socket socket = new Socket(address, 8000);


        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

        oos.writeObject("hello/world");

        boolean isvalid = (Boolean) ois.readObject();
        assertTrue(isvalid);



    }
    


    
}
