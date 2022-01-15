package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.playlist.domain.AllMember;
import toolc.yourlist.playlist.domain.AllPlaylists;
import toolc.yourlist.playlist.domain.UpdateRequest;

@RequiredArgsConstructor
public class JsonUpdateRequestMapper {
  private final AllMember allMember;
  private final AllPlaylists allPlaylists;

  UpdateRequest toUpdateRequest(JsonUpdateRequest jsonRequest) {
    var member = allMember.findById(jsonRequest.memberId());
    var playlist = allPlaylists.readBelongsTo(jsonRequest.playlistId());

    return new UpdateRequest(member, playlist, jsonRequest.title());
  }
}
