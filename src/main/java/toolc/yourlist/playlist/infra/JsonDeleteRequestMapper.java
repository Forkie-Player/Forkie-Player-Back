package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.playlist.domain.DeleteRequest;
import toolc.yourlist.playlist.domain.EqualOwnerFactory;

@RequiredArgsConstructor
public class JsonDeleteRequestMapper {
  private final EqualOwnerFactory factory;

  DeleteRequest toDeleteRequest(JsonDeleteRequest jsonRequest) {
    var equalOwner = factory.create(jsonRequest.memberId(), jsonRequest.playlistId());

    return new DeleteRequest(equalOwner);
  }
}
