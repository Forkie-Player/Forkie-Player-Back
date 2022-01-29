package toolc.yourlist.playlist.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EqualOwnerFactory {
  private final AllMember allMember;
  private final AllPlaylists allPlaylists;
  private final AllPlay allPlay;

  public EqualOwnerForPlaylist createForPlaylist(Long memberId, Long playlistId) {
    var member = allMember.findById(memberId);
    var playlist = allPlaylists.readBelongsTo(playlistId);

    return new EqualOwnerForPlaylist(member, playlist);
  }

  public EqualOwnerForPlay createForPlay(Long memberId, Long playId) {
    var member = allMember.findById(memberId);
    var play = allPlay.belongsTo(playId);
    var playlist = allPlaylists.readBelongsTo(play.playlistId());

    return new EqualOwnerForPlay(member, playlist, play);
  }
}
