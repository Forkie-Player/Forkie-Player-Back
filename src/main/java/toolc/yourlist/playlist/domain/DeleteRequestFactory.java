package toolc.yourlist.playlist.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteRequestFactory {
  private final AllMember allMember;
  private final AllPlaylists allPlaylists;

  public DeleteRequest create(Long memberId, Long playlistId) {
    var member = allMember.findById(memberId);
    var playlist = allPlaylists.readBelongsTo(playlistId);

    return new DeleteRequest(member, playlist);
  }
}
