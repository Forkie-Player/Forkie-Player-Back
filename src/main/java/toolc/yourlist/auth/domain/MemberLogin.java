package toolc.yourlist.auth.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import toolc.yourlist.member.domain.AllMember;

public class MemberLogin {

  private final AllMember allMember;

  public Token login(LoginRequest request) {
    allMember.findByLoginId("loginId");
    System.out.println("hello");
    return new Token();
  }
}
