package toolc.yourlist.playlist.infra;

import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;

import static io.vavr.control.Either.left;
import static io.vavr.control.Either.right;

@RequiredArgsConstructor
final class LoginIdMapper {
  private final MemberExistCondition memberExistCondition;

  Either<String, ReadRequest> toReadRequest(String loginId) {
    var existMember = memberExistCondition.check(loginId);

    if (existMember.isEmpty()) {
      return left(existMember.getLeft());
    }

    return right(new ReadRequest(loginId));
  }
}
