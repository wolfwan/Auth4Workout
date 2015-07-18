package AuthServer;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import business.*;

/**
 *
 * @author wwanless
 */
public class AuthServer extends Thread {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        SocketListener listener = new SocketListener();
        //SocketMgrRunnable listener = new SocketMgrRunnable();
        listener.run();
    }
}
