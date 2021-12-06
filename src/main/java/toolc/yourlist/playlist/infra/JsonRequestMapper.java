package toolc.yourlist.playlist.infra;

import toolc.yourlist.playlist.domain.UpdateRequest;

public class JsonRequestMapper {
  UpdateRequest toUpdateRequest(JsonUpdateRequest request) {
    return new UpdateRequest(
      request.memberId(),
      request.playlistId(),
      request.title());
  }
}
