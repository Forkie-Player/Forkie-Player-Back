package toolc.yourlist.playlist.infra;

import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import toolc.yourlist.playlist.domain.CreateUpdateRequest;
import toolc.yourlist.playlist.domain.UpdateRequest;

@RequiredArgsConstructor
public class JsonUpdateRequestMapper {
  private final CreateUpdateRequest factory;

  Either<String, UpdateRequest> toUpdateRequest(JsonUpdateRequest jsonRequest) {
    return factory.create(jsonRequest.memberId(),
      jsonRequest.playlistId(),
      jsonRequest.title());
  }
}
