package toolc.yourlist.playlist.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UpdateRequestFactory {
  private final AllMember allMember;
  private final AllPlaylists allPlaylists;

  public UpdateRequest create(Long memberId, Long playlistId, String newTitle) {
    var member = allMember.findById(memberId);
    var playlist = allPlaylists.readBelongsTo(playlistId);

    return new UpdateRequest(member, playlist, newTitle);
  }
}
