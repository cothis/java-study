package day022.protocol.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class CreateUserThread extends Thread {

    Socket client;
    public CreateUserThread(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            setNickname(client);
            System.out.println("접속된 Client 정보 : " + client.getInetAddress() +
                    ":" + client.getPort());

            new ServerThread(client).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setNickname(Socket socket) throws IOException {
        PrintWriter pw = new PrintWriter(socket.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        pw.println("\n이름을 입력해주세요 : ");
        pw.flush();

        String str = br.readLine();
        pw.println(str + "님 환영합니다.");
        pw.flush();

        for (Socket socket1 : Server.member.keySet()) {
            pw = new PrintWriter(socket1.getOutputStream());
            pw.println(str + "님이 들어오셨습니다.");
            pw.flush();
        }
        Server.member.put(socket, str);
    }
}
