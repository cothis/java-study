package day023.chatting.client.thread;

import day023.chatting.client.view.ChattingRoom;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientReceiveThread extends Thread {

    Socket socket;
    JTextArea textArea;
    ChattingRoom chattingRoom;
    boolean exit = false;

    public ClientReceiveThread(Socket socket, JTextArea textArea, ChattingRoom chattingRoom) {
        this.socket = socket;
        this.textArea = textArea;
        this.chattingRoom = chattingRoom;
    }

    public void setExit(boolean exit) {
        this.exit = exit;
    }

    @Override
    public void run() {
        super.run();
        while(true) {
            try {
                Thread.sleep(100);
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String str = br.readLine();
                textArea.append(str + "\n");

                if(exit) {
                    return;
                }
            } catch (IOException | InterruptedException e) {
                break;
            }
        }
    }
}
