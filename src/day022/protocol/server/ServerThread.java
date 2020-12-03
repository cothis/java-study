package day022.protocol.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServerThread extends Thread {

    Socket socket;

    public ServerThread(Socket client) {
        this.socket = client;
    }

    @Override
    public void run() {
        super.run();

        try {
            BufferedReader br = null;
            PrintWriter pw = null;

            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            while(true) {
                //recv
                String msg = null;
                msg = br.readLine();
                String ip = socket.getInetAddress().toString().split("\\.")[3];
                String id = Server.member.getOrDefault(socket, ip);
                System.out.println(id + ":" + msg); // 실질적으로 받는 부분

                //send
                if(!Server.sendSomeone(id, msg)) {
                    for (Socket target : Server.member.keySet()) {
                        if (target != socket) {
                            pw = new PrintWriter(target.getOutputStream());
                            pw.println(ip + "(" + id + "):" + msg);
                            pw.flush();
                        }
                    }
                }

                sleep(500);
            }
        } catch (IOException | InterruptedException e) {
            System.out.println(socket.getLocalSocketAddress() + ":" +socket.getPort() + " closed");
        }
    }
}
