package day023.chatting.server.thread;

import day023.chatting.server.ServerMain;
import day023.chatting.server.member.Member;

import java.io.*;
import java.net.Socket;

import static day023.chatting.server.ServerMain.*;

public class CreateMemberThread extends Thread {

    private Socket client;

    public CreateMemberThread(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        super.run();
        PrintWriter pw = null;
        BufferedReader br = null;
        String name = null;
        try {
            pw = new PrintWriter(client.getOutputStream(), true);
            pw.println("닉네임을 입력해주세요");

            br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            name = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        getRepository().addMember(new Member(client, name));

        new ReceiveThread(client).start();
    }
}
