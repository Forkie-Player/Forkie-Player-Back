package toolc.yourlist.playlist.domain;

import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SaveRequestFactory {
  private final AllMember allMember;

  public Either<String, SaveRequest> create(Long memberId, String title) {
    if (!allMember.exist(memberId)) {
      return Either.left("존재하지 않는 회원");
    }

    var member = allMember.findById(memberId);

    return Either.right(new SaveRequest(member, title));
  }
}
