/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.net.*;
import java.io.*;

/**
 *
 * @author wwanless
 */
public class SocketMgrRunnable extends Thread implements Runnable {

    private Socket socket = null;

    public SocketMgrRunnable(Socket socket) {
        this.socket = socket;
    }





    private boolean authenticate(String credentials) {
        String[] tokens = credentials.split("/");
        String username = tokens[0];
        String password = tokens[1];

        if (tokens.length != 2) {
            return false;
        }

        if (username.equals("hello") && password.equals("world")) {
            return true;
        } else {
            return false;
        }
    }

    
    @Override
    public void run() {
        try {
            //ServerSocket ss = new ServerSocket(8000, 100);
              //  Socket socket = ss.accept(); //just repeats wating for a connection request
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                String credentials = (String) ois.readObject();
                boolean valid = authenticate(credentials);
                
                oos.writeObject(valid);
                
                oos.flush();
                socket.close();
                System.out.println("...Ending thread");

        } catch (Exception ex) {
            System.out.println("exception: " + ex.getMessage());
        }
    }
    }

