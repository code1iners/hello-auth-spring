package hello.codeliner.auth.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import hello.codeliner.auth.model.Member;
import hello.codeliner.auth.model.MemberDto;
import hello.codeliner.auth.repository.MemberRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
    
    private final MemberRepository memberRepository;
    
    public MemberDto createNewMember(Member member) {
        Optional<Member> foundMember = memberRepository.findByEmail(member.getEmail());
        if (!foundMember.isPresent()) {
            Member createdMember = memberRepository.save(member);
            return createdMember.convertToDto();
        }
        return null;
    }

    public MemberDto getUserByEmailWithPassword(String email, String password) {
        Optional<Member> foundMember = memberRepository.findByEmail(email);
        if (foundMember.isPresent()) {
            Member member = foundMember.get();
            if (member.getEmail().equals(email) && member.getPassword().equals(password)) {
                return member.convertToDto();
            }
        }
        return null;
    }
}
