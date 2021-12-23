package toolc.yourlist.playlist.infra;

import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import toolc.yourlist.playlist.domain.UpdateRequest;
import toolc.yourlist.playlist.domain.UpdateRequestFactory;

@RequiredArgsConstructor
public class JsonUpdateRequestMapper {
  private final UpdateRequestFactory factory;

  Either<String, UpdateRequest> toUpdateRequest(JsonUpdateRequest jsonRequest) {
    return factory.create(jsonRequest.memberId(),
      jsonRequest.playlistId(),
      jsonRequest.title());
  }
}
