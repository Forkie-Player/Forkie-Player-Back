package toolc.yourlist.playlist.infra;

import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import toolc.yourlist.playlist.domain.ReadRequest;
import toolc.yourlist.playlist.domain.ReadRequestFactory;

@RequiredArgsConstructor
public class MemberIdMapper {
  private final ReadRequestFactory factory;

  Either<String, ReadRequest> toReadRequest(String memberId) {
    return factory.create(memberId);
  }
}
