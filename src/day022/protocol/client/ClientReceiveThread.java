package day022.protocol.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientReceiveThread extends Thread {

    BufferedReader br;
    Socket socket;

    public ClientReceiveThread(Socket socket) throws IOException {
        this.socket = socket;
        this.br = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
        );
    }

    @Override
    public void run() {
        try {
            while(true) {
                System.out.println(br.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
