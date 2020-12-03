package day023.chatting.server.thread;

import day023.chatting.server.ServerMain;
import day023.chatting.server.member.Member;

import java.io.*;
import java.net.Socket;
import java.util.Locale;

import static day023.chatting.server.ServerMain.*;

public class ReceiveThread extends Thread {

    private Socket client;

    public ReceiveThread(Socket client) {
        this.client = client;
        setDaemon(true);
    }

    @Override
    public void run() {
        super.run();


        try {
        //    for (Member member : getRepository().findAllMember()) {
                ObjectOutputStream os = new ObjectOutputStream(client.getOutputStream());
                os.writeObject("heloo");
                os.flush();
        //    }
            System.out.println("write");

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(getRepository().findBySocket(client).getName() + "님이 입장했습니다.");
        for (Member member : getRepository().findAllMember()) {
            try {
                PrintWriter pw = new PrintWriter(member.getSocket().getOutputStream(), true);
                pw.println(getRepository().findBySocket(client).getName() + "님이 입장했습니다.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        while (true) {
            try {
                Thread.sleep(100);
                BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
                String msg = br.readLine();
                if(msg == null) continue;

                String name = getRepository().findBySocket(client).toString();
                System.out.println(name + ": "+ msg);
                if (!sendSomeone(name, msg)) {
                    getRepository().findAllMember().forEach(member -> {
                        try {
                            if(member.getSocket() != client) {
                                PrintWriter pw = new PrintWriter(member.getSocket().getOutputStream(), true);
                                pw.println(name + ": " + msg);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
                }
            } catch (IOException e) {
                System.out.println(getRepository().findBySocket(client).toString() + "님이 나가셨습니다.");
                getRepository().findAllMember().forEach(member -> {
                    try {
                        if(member.getSocket() != client) {
                            PrintWriter pw = new PrintWriter(member.getSocket().getOutputStream(), true);
                            pw.println(getRepository().findBySocket(client).toString() + "님이 나가셨습니다.");
                            getRepository().removeMember(getRepository().findBySocket(client));
                        }
                    } catch (IOException io) {
                        e.printStackTrace();
                    }
                });
                e.printStackTrace();
                break;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
