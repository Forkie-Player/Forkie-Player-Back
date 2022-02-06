package toolc.yourlist.member.domain;

import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;

import java.time.Period;

import static io.vavr.control.Either.left;
import static io.vavr.control.Either.right;

@RequiredArgsConstructor
public class MemberAuthProvider {

  private final TokenProvider tokenProvider;
  private final AllMember allMember;

  public Either<String, Token> registerMember(MemberRegisterAndLoginRequest request) {
    if (allMember.isExistByLoginId(request.loginId())) {
      return left("Already register Member");
    } else {
      allMember.registerMember(request.loginId(), request.password());
      return right(getMemberToken(request).get());
    }
  }

  public Either<String, Token> getMemberToken(MemberRegisterAndLoginRequest request) {
    Long id = allMember.findIdByLoginId(request.loginId());
    Period refreshTokenExpiration = request.isPC() ? Period.ofDays(7) : Period.ofDays(90);
    return right(tokenProvider.makeToken(id, refreshTokenExpiration, UserType.MEMBER));
  }
}
