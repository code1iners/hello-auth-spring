package hello.codeliner.auth.controller;

import hello.codeliner.auth.model.Member;
import hello.codeliner.auth.model.MemberDto;
import hello.codeliner.auth.service.MemberService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping(path = "")
    public MemberDto createMember(@RequestBody Member member) {
        MemberDto createdNewMember = memberService.createNewMember(member);
        return createdNewMember;
    }

    @PostMapping(path = "/sign-in")
    public MemberDto signInWithEmailWithPassword(@RequestBody Member member) {
        MemberDto foundUser = memberService.getUserByEmailWithPassword(member.getEmail(), member.getPassword());
        return foundUser;
    }
}
