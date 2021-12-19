package toolc.yourlist.playlist.infra;

import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import toolc.yourlist.playlist.domain.CreateReadRequest;
import toolc.yourlist.playlist.domain.ReadRequest;

@RequiredArgsConstructor
public class MemberIdMapper {
  private final CreateReadRequest factory;

  Either<String, ReadRequest> toReadRequest(String memberId) {
    try {
      if (memberId == null) {
        return Either.left("입력이 비어있습니다.");
      }

      return factory.create(Long.parseLong(memberId));
    } catch (NumberFormatException e) {
      return Either.left("입력이 숫자 형식이 아닙니다.");
    }
  }
}
