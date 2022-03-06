package toolc.yourlist.playlist.domain;

import lombok.RequiredArgsConstructor;

// TODO: 이름도 바꾸고 이 2개는 나눠서 factory에서 생성하던 해야할 듯
@RequiredArgsConstructor
public class ValidRequestFactory {
  private final AllPlaylists allPlaylists;
  private final AllPlay allPlay;

  public ValidRequestForPlaylist createForPlaylist(User user, Long playlistId) {
    var playlist = allPlaylists.readBelongsTo(playlistId);

    return new ValidRequestForPlaylist(user, playlist);
  }

  public ValidRequestForPlay createForPlay(User user, Long playlistId, Long playId) {
    var play = allPlay.belongsTo(playId);
    var playlist = allPlaylists.readBelongsTo(playlistId);

    return new ValidRequestForPlay(user, playlist, play);
  }
}
