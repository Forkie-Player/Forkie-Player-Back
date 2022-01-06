package toolc.yourlist.playlist.domain;

import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ReadRequestFactory {
  private final AllMember allMember;

  public Either<String, ReadRequest> create(String memberId) {
    try {
      Long id = Long.parseLong(memberId);
      var member = allMember.findById(id);

      return Either.right(new ReadRequest(member));
    } catch (NumberFormatException e) {
      return Either.left("입력이 숫자 형식이 아닙니다.");
    }
  }
}
