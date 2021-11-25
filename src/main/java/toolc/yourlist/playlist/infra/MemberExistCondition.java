package toolc.yourlist.playlist.infra;

import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import toolc.yourlist.member.domain.AllMember;
import toolc.yourlist.member.infra.Member;

import static io.vavr.control.Either.left;
import static io.vavr.control.Either.right;

@RequiredArgsConstructor
class MemberExistCondition {
  private final AllMember allMember;

  Either<String, Member> check(String loginId) {
    try {
      var member = allMember.findByLoginId(loginId);
      return right(member);
    } catch (IllegalArgumentException e) {
      return left(e.getMessage());
    }
  }
}
