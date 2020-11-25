package homework_testing.tenth;

import java.io.*;
import java.net.*;
import java.util.*;

public class Servers {
    static List<Socket> sockets = new Vector<>();

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(5200);
        boolean flag = true;

        while (flag) {
            try {

                Socket accept = server.accept();
                synchronized (sockets) {
                    sockets.add(accept);
                }

                Thread thread = new Thread(new ServerThread(accept));
                thread.start();

            } catch (Exception e) {
                flag = false;
                e.printStackTrace();
            }
        }

        server.close();
    }

}
