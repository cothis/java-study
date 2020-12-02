package day022.protocol.server;

import java.io.IOException;
import java.net.Socket;

public class CreateUserThread extends Thread {

    Socket client;
    public CreateUserThread(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            Server.setNickname(client);
            System.out.println("접속된 Client 정보 : " + client.getInetAddress() +
                    ":" + client.getPort());

            new ServerThread(client).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
