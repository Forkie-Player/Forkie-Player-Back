package toolc.yourlist.playlist.infra;

import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import toolc.yourlist.member.domain.AllMember;
import toolc.yourlist.playlist.domain.ReadRequest;

import static io.vavr.control.Either.left;
import static io.vavr.control.Either.right;

@RequiredArgsConstructor
final class LoginIdMapper {
  private final AllMember allMember;

  Either<String, ReadRequest> toReadRequest(String loginId) {
    try {
      var existMember = allMember.findByLoginId(loginId);
      return right(new ReadRequest(existMember.loginId()));
    } catch (Exception e) {
      return left(e.getMessage());
    }
  }
}
