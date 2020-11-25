package inclass.c10;

import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    static int Port = 1234;
    static List<ClientHandler> ar
            = new ArrayList<>();
    static int i = 0;

    public static void main(String[] args)
            throws IOException {
        ServerSocket ss = new ServerSocket(Port);
        Socket s;
// looping for getting client request
        while (true) {
// Accept the incoming request
            s = ss.accept();
            System.out.println(
                    "New client request received : "
                            + s);
// obtain input and output streams
            DataInputStream dis =
                    new DataInputStream(
                            s.getInputStream());
            DataOutputStream dos =
                    new DataOutputStream(
                            s.getOutputStream());
// Create a new handler object for handling this request.
            System.out.println(
                    "Creating a new handler for this client...");
            ClientHandler mtch =
                    new ClientHandler(
                            s, "client " + i++,
                            dis, dos);
// add this client to active clients list
            System.out.println(
                    "Adding this client to active client list");
            ar.add(mtch);
// Start a new Thread with this object.
            new Thread(mtch).start();
        }
    }
}
