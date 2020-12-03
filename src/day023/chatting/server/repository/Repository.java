package day023.chatting.server.repository;

import day023.chatting.server.member.Member;

import java.net.Socket;
import java.util.*;

public class Repository {

    private final List<Member> list;

    public Repository() {
        this.list = new ArrayList<>();
    }

    public void addMember(Member member) {
        list.add(member);
    }

    public void removeMember(Member member) {
        list.remove(member);
    }

    public Member findBySocket(Socket socket) {
        return list.stream().filter(member -> member.getSocket() == socket).findAny().orElse(null);
    }

    public Member findByName(String name) {
        return list.stream().filter(member -> member.getName().equals(name)).findAny().orElse(null);
    }

    public List<Member> findAllMember() {
        return list;
    }
}
