package toolc.yourlist.playlist.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EqualMemberFactory {
  private final AllMember allMember;
  private final AllPlaylists allPlaylists;
  private final AllPlay allPlay;

  public ValidRequestForPlaylist createForPlaylist(Long memberId, Long playlistId) {
    var member = allMember.findById(memberId);
    var playlist = allPlaylists.readBelongsTo(playlistId);

    return new ValidRequestForPlaylist(member, playlist);
  }

  public ValidRequestForPlay createForPlay(Long memberId, Long playlistId, Long playId) {
    var member = allMember.findById(memberId);
    var play = allPlay.belongsTo(playId);
    var playlist = allPlaylists.readBelongsTo(playlistId);

    return new ValidRequestForPlay(member, playlist, play);
  }
}
