package day016.account.repository;

import day016.account.domain.Member;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MemoryRepository implements AccountRepository {
    List<Member> members = new ArrayList<>();
    Long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        members.add(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(members.get(Math.toIntExact(id)));
    }

    @Override
    public Optional<Member> findByName(String name) {
        Member result = null;
        for(Member member : members) {
            if(member.getName().equals(name)){
                result = member;
            }
        }
        return Optional.ofNullable(result);
    }

    @Override
    public List<Member> findAll() {
        return members;
    }
}
