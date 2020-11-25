package inclass.c10;

import java.io.*;
import java.net.*;
import java.util.*;

public class Client {
    static String ServerIP = "localhost";
    static int ServerPort = 1234;

    public static void main(String args[]) throws Exception {
        Scanner scn = new Scanner(System.in);
        Socket s = new Socket(ServerIP, ServerPort);
        DataInputStream dis =
                new DataInputStream(s.getInputStream());
        DataOutputStream dos =
                new DataOutputStream(s.getOutputStream());

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        // read the message to deliver.
                        String msg = scn.nextLine();
                        // write on the output stream
                        dos.writeUTF(msg);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        // read the message sent to this client
                        String msg = dis.readUTF();
                        System.out.println(msg);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}