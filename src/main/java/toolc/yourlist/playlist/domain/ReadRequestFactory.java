package toolc.yourlist.playlist.domain;

import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import toolc.yourlist.member.domain.AllMember;

@RequiredArgsConstructor
public class ReadRequestFactory implements CreateReadRequest {
  private final AllMember allMember;

  public Either<String, ReadRequest> create(Long memberId) {
    var member = allMember.findById(memberId);

    if (member.isEmpty()) {
      return Either.left("존재하지 않는 회원");
    }

    return Either.right(new ReadRequest(member.get()));
  }
}
