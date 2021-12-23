package toolc.yourlist.playlist.domain;

import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import toolc.yourlist.member.domain.AllMember;

@RequiredArgsConstructor
public class ReadRequestFactory {
  private final AllMember allMember;

  public Either<String, ReadRequest> create(String memberId) {
    try {
      if (memberId == null) {
        return Either.left("입력이 비어있습니다.");
      }

      var member = allMember.findById(Long.parseLong(memberId));
      if (member.isEmpty()) {
        return Either.left("존재하지 않는 회원");
      }

      return Either.right(new ReadRequest(member.get()));
    } catch (NumberFormatException e) {
      return Either.left("입력이 숫자 형식이 아닙니다.");
    }
  }
}
