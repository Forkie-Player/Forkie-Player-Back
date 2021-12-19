package toolc.yourlist.playlist.infra;

import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import toolc.yourlist.playlist.domain.CreateSaveRequest;
import toolc.yourlist.playlist.domain.SaveRequest;

@RequiredArgsConstructor
public class JsonSaveRequestMapper {
  private final CreateSaveRequest factory;

  Either<String, SaveRequest> toCreateRequest(JsonSaveRequest jsonRequest) {
    return factory.create(jsonRequest.memberId(), jsonRequest.title());
  }
}
