package toolc.yourlist.playlist.domain;

import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ReadRequestFactory {
  private final AllMember allMember;

  public Either<String, ReadRequest> create(String memberId) {
    try {
      if (memberId == null) {
        return Either.left("입력이 비어있습니다.");
      }

      Long id = Long.parseLong(memberId);

      if (!allMember.exist(id)) {
        return Either.left("존재하지 않는 회원");
      }

      var member = allMember.findById(id);

      return Either.right(new ReadRequest(member));
    } catch (NumberFormatException e) {
      return Either.left("입력이 숫자 형식이 아닙니다.");
    }
  }
}
