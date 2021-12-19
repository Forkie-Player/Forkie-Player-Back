package toolc.yourlist.playlist.infra;

import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import toolc.yourlist.playlist.domain.CreateRequest;
import toolc.yourlist.playlist.domain.CreateRequestFactory;

@RequiredArgsConstructor
public class JsonCreateRequestMapper {
  private final CreateRequestFactory factory;

  Either<String, CreateRequest> toCreateRequest(JsonCreateRequest jsonRequest) {
    return factory.create(jsonRequest.memberId(),
      jsonRequest.title());
  }
}
