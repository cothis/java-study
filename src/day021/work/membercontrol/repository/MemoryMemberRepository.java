package day021.work.membercontrol.repository;

import day021.work.membercontrol.dto.Member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Integer, Member> store;
    private Integer sequence;

    public MemoryMemberRepository() {
        store = new HashMap<>();
        sequence = 0;
    }

    @Override
    public void addMember(Member member) {
        member.setId(++sequence);
        store.put(sequence, member);
    }

    @Override
    public void removeMember(Integer memberId) {
        store.remove(memberId);
    }

    @Override
    public Member findById(Integer memberId) {
        return store.get(memberId);
    }

    @Override
    public Member findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny()
                .get();
    }

    @Override
    public void updateMember(Integer memberId, Member member) {
        store.replace(memberId, member);
    }

    @Override
    public List<Member> findAllMember() {
        return new ArrayList<>(store.values());
    }
}
