package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.playlist.domain.DeleteRequest;
import toolc.yourlist.playlist.domain.DeleteRequestFactory;

@RequiredArgsConstructor
public class JsonDeleteRequestMapper {
  private final DeleteRequestFactory factory;

  DeleteRequest toDeleteRequest(JsonDeleteRequest jsonRequest) {
    return factory.create(jsonRequest.memberId(), jsonRequest.playlistId());
  }
}
