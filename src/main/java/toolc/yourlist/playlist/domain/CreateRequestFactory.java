package toolc.yourlist.playlist.domain;

import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import toolc.yourlist.member.domain.AllMember;

@RequiredArgsConstructor
public class CreateRequestFactory {
  private final AllMember allMember;

  public Either<String, CreateRequest> create(Long memberId, String title) {
    var member = allMember.findById(memberId);

    if (member.isEmpty()) {
      return Either.left("존재하지 않는 회원");
    }

    return Either.right(new CreateRequest(member.get(), title));
  }
}
