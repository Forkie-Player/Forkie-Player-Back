package toolc.yourlist.playlist.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PlaylistReader {
  private final AllMember allMember;
  private final AllPlaylists allPlaylists;

  public Playlists belongsTo(Long memberId) {
    return allPlaylists.readAllBelongsTo(allMember.findById(memberId).id());
  }
}
