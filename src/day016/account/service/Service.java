package day016.account.service;

import day016.account.domain.Member;
import day016.account.repository.AccountRepository;

import java.util.List;

public class Service {
    private AccountRepository accountRepository;

    public Service(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void join(Member member) {
        try {
            checkDuplicatedMember(member);
            accountRepository.save(member);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Member> findMembers() {
        return accountRepository.findAll();
    }

    private void checkDuplicatedMember(Member member) {
        accountRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException(m.getName() + "은 이미 존재하는 회원입니다.");
                    });
    }
}
