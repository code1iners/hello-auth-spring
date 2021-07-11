package hello.codeliner.auth.model;
import lombok.Data;

@Data
public class MemberDto {
    private Long id;
    private String email;
    private String username;
}
