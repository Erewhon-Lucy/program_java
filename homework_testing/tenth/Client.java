package homework_testing.tenth;

import java.io.*;
import java.net.*;
import java.util.*;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 5200);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(socket.getOutputStream());
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        new Thread(() -> {
            try {
                while (true) {
                    System.out.println(in.readLine());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        String line = reader.readLine();
        while (!"exit".equalsIgnoreCase(line)) {

            out.println(line);
            out.flush();

            line = reader.readLine();
        }
        out.close();
        in.close();
        socket.close();
    }
}
