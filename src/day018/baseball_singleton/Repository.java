package day018.baseball_singleton;

import java.util.*;

public class Repository {
    private Map<Integer, Member> list = new HashMap<>();
    private int sequence = 0;

    private Repository() {}

    private static class RepoLoader {
        private static Repository repository = new Repository();
    }

    public static Repository getInstance() {
        return RepoLoader.repository;
    }

    public int add(Member member) {
        if(member.getId() == 0) {
            member.setId(++sequence);
        }
        sequence = member.getId();
        list.put(sequence, member);
        return sequence;
    }

    public Member remove(Member member) {
        list.remove(member.getId());
        return member;
    }

    public Optional<Member> remove(int key) {
        return Optional.ofNullable(list.remove(key));
    }

    public Optional<Member> findById(int key) {
        return Optional.ofNullable(list.get(key));
    }

    public Optional<Member> findByName(String name) {
        return list.values().stream().filter(m -> m.getName().equals(name)).findAny();
    }

    public List<Member> findAll() {
        return new ArrayList<>(list.values());
    }

}
