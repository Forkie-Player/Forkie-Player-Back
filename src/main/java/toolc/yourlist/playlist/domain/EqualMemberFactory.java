package toolc.yourlist.playlist.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EqualMemberFactory {
  private final AllMember allMember;
  private final AllPlaylists allPlaylists;
  private final AllPlay allPlay;

  public EqualMemberForPlaylist createForPlaylist(Long memberId, Long playlistId) {
    var member = allMember.findById(memberId);
    var playlist = allPlaylists.readBelongsTo(playlistId);

    return new EqualMemberForPlaylist(member, playlist);
  }

  public EqualMemberForPlay createForPlay(Long memberId, Long playId) {
    var member = allMember.findById(memberId);
    var play = allPlay.belongsTo(playId);
    var playlist = allPlaylists.readBelongsTo(play.playlistId());

    return new EqualMemberForPlay(member, playlist, play);
  }
}
