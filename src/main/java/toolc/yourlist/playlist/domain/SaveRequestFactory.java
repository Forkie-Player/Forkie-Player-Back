package toolc.yourlist.playlist.domain;

import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import toolc.yourlist.member.domain.AllMember;

@RequiredArgsConstructor
public class SaveRequestFactory {
  private final AllMember allMember;

  public Either<String, SaveRequest> create(Long memberId, String title) {
    var member = allMember.findById(memberId);

    if (member.isEmpty()) {
      return Either.left("존재하지 않는 회원");
    }

    return Either.right(new SaveRequest(member.get(), title));
  }
}
