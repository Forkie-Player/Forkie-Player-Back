package toolc.yourlist.member.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.member.domain.Member;
import toolc.yourlist.member.domain.loginId.LoginIdFactory;
import toolc.yourlist.member.domain.password.PasswordFactory;

@RequiredArgsConstructor
public class MemberEntityToDomainAdapter {
  private final LoginIdFactory loginIdFactory;
  private final PasswordFactory passwordFactory;

  Member toDomainMember(MemberEntity entity) {
    return new Member(loginIdFactory.create(entity.loginId()),
      passwordFactory.create(entity.password()));
  }
}
