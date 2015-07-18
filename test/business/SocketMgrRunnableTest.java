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
public class SocketMgrRunnableTest {

    public SocketMgrRunnableTest() {
    }

    @Test
    public void testSocketMgrRunnable() throws Exception {

        InetAddress address = InetAddress.getLocalHost();
        Socket socket = new Socket(address, 8000);
        SocketMgrRunnable mgr = new SocketMgrRunnable(socket);

        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

        oos.writeObject("hello/world");
        oos.flush();
        boolean isvalid = (Boolean) ois.readObject();
        assertTrue(isvalid);

        socket.close();

        Socket socket2 = new Socket(address, 8000);
        SocketMgrRunnable mgr2 = new SocketMgrRunnable(socket2);
        ObjectOutputStream oos2 = new ObjectOutputStream(socket2.getOutputStream());
        ObjectInputStream ois2 = new ObjectInputStream(socket2.getInputStream());

        oos2.writeObject("goodbye/earth");
        oos2.flush();
        boolean isvalid2 = (Boolean) ois2.readObject();
        assertFalse(isvalid2);

    }
}
