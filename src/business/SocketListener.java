/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.net.*;


/**
 *
 * @author wwanless
 */
public class SocketListener{

    public void run() {
        try {
            ServerSocket ss = new ServerSocket(8000, 100);

            while (true) {
                System.out.println("Starting new thread...");
                Socket socket = ss.accept(); //just repeats wating for a connection request
                SocketMgrRunnable mgr = new SocketMgrRunnable(socket);
                Thread thread = new Thread(mgr);
                thread.start();

            }
            
            
        } catch (Exception ex) {
            System.out.println("exception: " + ex.getMessage());
        }


    }
}