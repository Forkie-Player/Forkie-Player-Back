package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.playlist.domain.AllMember;
import toolc.yourlist.playlist.domain.AllPlaylists;
import toolc.yourlist.playlist.domain.DeleteRequest;

@RequiredArgsConstructor
public class JsonDeleteRequestMapper {
  private final AllMember allMember;
  private final AllPlaylists allPlaylists;

  DeleteRequest toDeleteRequest(JsonDeleteRequest jsonRequest) {
    var member = allMember.findById(jsonRequest.memberId());
    var playlist = allPlaylists.readBelongsTo(jsonRequest.playlistId());

    return new DeleteRequest(member, playlist);
  }
}
