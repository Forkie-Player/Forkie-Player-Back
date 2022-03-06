package toolc.yourlist.playlist.domain;

import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PlaylistCreator {
  private final AllPlaylists allPlaylists;
  private final SavePolicy savePolicy = new SavePolicy();

  public Either<String, Boolean> create(SaveRequest request) {
    var playlistCount = allPlaylists.havingCountOf(request.user());

    if (!savePolicy.match(request.user(), playlistCount)) {
      return Either.left("비회원의 영상 생성 제한을 넘었습니다.");
    }

    save(playlist(request.user(), request.title()));
    return Either.right(Boolean.TRUE);
  }

  private void save(Playlist playlist) {
    allPlaylists.save(playlist);
  }

  private Playlist playlist(User user, String title) {
    return Playlist.builder()
      .userCode(user.code())
      .title(title)
      .build();
  }
}
