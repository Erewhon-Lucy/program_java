package homework_testing.tenth;

import java.net.*;
import java.io.*;

public class ServerThread extends Servers implements Runnable {
    Socket socket;
    String socketName;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            socketName = socket.getRemoteSocketAddress().toString();
            System.out.println("用户" + socketName + "加入聊天");
            print("用户" + socketName + "加入聊天");
            boolean flag = true;
            while (flag) {

                String line = reader.readLine();

                if (line == null) {
                    flag = false;
                    continue;
                }
                String msg = "用户" + socketName + ":" + line;
                System.out.println(msg);

                print(msg);
            }

            closeConnect();
        } catch (IOException e) {
            try {
                closeConnect();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    private void print(String msg) throws IOException {
        PrintWriter out;
        synchronized (sockets) {
            for (Socket sc : sockets) {
                out = new PrintWriter(sc.getOutputStream());
                out.println(msg);
                out.flush();
            }
        }
    }

    public void closeConnect() throws IOException {
        System.out.println("用户" + socketName + "退出了聊天室");
        print("用户" + socketName + "退出了聊天室");

        synchronized (sockets) {
            sockets.remove(socket);
        }
        socket.close();
    }

}
