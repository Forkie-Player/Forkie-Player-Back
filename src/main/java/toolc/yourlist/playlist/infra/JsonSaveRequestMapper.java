package toolc.yourlist.playlist.infra;

import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import toolc.yourlist.playlist.domain.SaveRequest;
import toolc.yourlist.playlist.domain.SaveRequestFactory;

@RequiredArgsConstructor
public class JsonSaveRequestMapper {
  private final SaveRequestFactory factory;

  Either<String, SaveRequest> toCreateRequest(JsonSaveRequest jsonRequest) {
    return factory.create(jsonRequest.memberId(), jsonRequest.title());
  }
}
