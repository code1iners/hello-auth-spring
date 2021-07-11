package hello.codeliner.auth.model;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String email;

    private String username;

    private String password;
    
    public MemberDto convertToDto() {
        MemberDto memberDto = new MemberDto();
        memberDto.setId(this.id);
        memberDto.setEmail(this.email);
        memberDto.setUsername(this.username);
        return memberDto;
    }
}
