package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.playlist.domain.AllMember;
import toolc.yourlist.playlist.domain.AllPlaylists;
import toolc.yourlist.playlist.domain.EqualOwnerFactory;
import toolc.yourlist.playlist.domain.UpdateRequest;

@RequiredArgsConstructor
public class JsonUpdateRequestMapper {
  private final EqualOwnerFactory factory;

  UpdateRequest toUpdateRequest(JsonUpdateRequest jsonRequest) {
    var equalOwner= factory.create(jsonRequest.memberId(), jsonRequest.playlistId());

    return new UpdateRequest(equalOwner, jsonRequest.title());
  }
}
