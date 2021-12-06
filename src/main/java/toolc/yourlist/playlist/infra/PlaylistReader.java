package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.member.domain.AllMember;
import toolc.yourlist.playlist.domain.AllPlaylists;
import toolc.yourlist.playlist.domain.ListOfPlaylists;
import toolc.yourlist.playlist.domain.ReadPlaylist;

@RequiredArgsConstructor
class PlaylistReader implements ReadPlaylist {
  private final AllMember allMember;
  private final AllPlaylists allPlaylists;

  @Override
  public ListOfPlaylists belongsTo(Long memberId) {
    var member = allMember.findById(memberId);
    return allPlaylists.readAllBelongsTo(memberId);
  }
}
