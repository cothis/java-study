package day023.chatting.server.thread;

import day023.chatting.server.member.Member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import static day023.chatting.server.ServerMain.*;

public class PrintMessageThread extends Thread {
    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw;
        while(true) {
            String msg = sc.nextLine();
            if(!sendSomeone("서버", msg)) {
                for (Member member : getRepository().findAllMember()) {
                    try {
                        pw = new PrintWriter(member.getSocket().getOutputStream(), true);
                        pw.println("서버: " + msg);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
