package day023.chatting.server;

import day022.protocol.server.Server;
import day023.chatting.server.member.Member;
import day023.chatting.server.repository.Repository;
import day023.chatting.server.thread.CreateMemberThread;
import day023.chatting.server.thread.PrintMessageThread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Optional;

public class ServerMain {

    private static Repository repository = new Repository();

    public static Repository getRepository() {
        return repository;
    }

    public static void main(String[] args) {

        new PrintMessageThread().start();

        try {
            ServerSocket server = new ServerSocket(9000);
            System.out.println(server.getLocalSocketAddress() + " Open!");

            // Server Print Thread start

            while (true) {
                Socket client = server.accept();
                new CreateMemberThread(client).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean sendSomeone(String sender, String msg) {
        if(msg == null || msg.length() == 0) {
            return false;
        }
        if (msg.charAt(0) == '@') {
            int msgStart = msg.indexOf(' ');
            String senderName = msg.substring(1, msgStart);
            String content = msg.substring(msgStart + 1);

            Member target = repository.findByName(senderName);

            if(target != null) {
                try {
                    PrintWriter pwt = new PrintWriter(target.getSocket().getOutputStream());
                    pwt.println(sender + "@당신: " + content);
                    pwt.flush();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                return true;
            }
            else {
                return false;
            }
        } else {
            return false;
        }
    }
}
