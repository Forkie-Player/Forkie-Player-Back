package toolc.yourlist.playlist.infra;

import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import toolc.yourlist.playlist.domain.DeleteRequest;
import toolc.yourlist.playlist.domain.DeleteRequestFactory;

@RequiredArgsConstructor
public class JsonDeleteRequestMapper {
  private final DeleteRequestFactory factory;

  Either<String, DeleteRequest> toDeleteRequest(JsonDeleteRequest jsonRequest) {
    return factory.create(jsonRequest.memberId(), jsonRequest.playlistId());
  }
}
