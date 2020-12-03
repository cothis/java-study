package day023.chatting.server.member;

import java.net.Socket;

public class Member {

    private Socket socket;
    private String name;

    public Member() {
    }

    public Member(Socket socket, String name) {
        this.socket = socket;
        this.name = name;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + "(" + socket.getInetAddress().toString().split("\\.")[3] + ")";
    }
}
