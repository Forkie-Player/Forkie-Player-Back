package toolc.yourlist.playlist.infra;

import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import toolc.yourlist.playlist.domain.AllMember;
import toolc.yourlist.playlist.domain.ReadRequest;

@RequiredArgsConstructor
public class MemberIdMapper {
  private final AllMember allMember;

  Either<String, ReadRequest> toReadRequest(String memberId) {
    try {
      Long id = Long.parseLong(memberId);
      var member = allMember.findById(id);

      return Either.right(new ReadRequest(member));
    } catch (NumberFormatException e) {
      return Either.left("입력이 숫자 형식이 아닙니다.");
    }
  }
}
