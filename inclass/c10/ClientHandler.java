package inclass.c10;

import java.net.*;
import java.io.*;
import java.util.*;

class ClientHandler implements Runnable {
    Scanner scn = new Scanner(System.in);
    private String name;
    final DataInputStream dis;
    final DataOutputStream dos;
    Socket s;
    boolean isloggedin;

    // constructor
    public ClientHandler(Socket s, String name,
                         DataInputStream dis, DataOutputStream dos) {
        this.dis = dis;
        this.dos = dos;
        this.name = name;
        this.s = s;
        this.isloggedin = true;
    }

    public void run() {
        try {
            String received;
            while (true) {
// receive the string
                received = dis.readUTF();
                System.out.println(received);
                if (received.equals("logout")) {
                    this.isloggedin = false;
                    this.s.close();
                    break;
                }
// send to all other clients
                for (ClientHandler mc : Server.ar) {
                    if (!mc.name.equals(name)) {
                        mc.dos.writeUTF(
                                this.name + ": "
                                        + received);
                    }
                }
            }
// closing resources
            this.dis.close();
            this.dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
