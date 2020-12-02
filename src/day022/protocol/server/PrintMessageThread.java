package day022.protocol.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class PrintMessageThread extends Thread {

    public PrintMessageThread() {
    }

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw;
        while(true) {
            String msg = sc.nextLine();
            if(!Server.sendSomeone("서버", msg)) {
                for (Socket target : Server.member.keySet()) {
                    try {
                        pw = new PrintWriter(target.getOutputStream());
                        pw.println("서버: " + msg);
                        pw.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
