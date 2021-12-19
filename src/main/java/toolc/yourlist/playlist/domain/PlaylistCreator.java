package toolc.yourlist.playlist.domain;

import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PlaylistCreator {
  private final AllPlaylists allPlaylists;
  private final CreatePolicy createPolicy = new CreatePolicy();

  public Either<String, Boolean> createPlaylist(SaveRequest request) {
    var playlistCount = allPlaylists.havingCountOf(request.member().id());

    if (!createPolicy.match(request.member(), playlistCount)) {
      return Either.left("비회원의 영상 생성 제한을 넘었습니다.");
    }

    save(playlist(request.member().id(), request.title()));
    return Either.right(Boolean.TRUE);
  }

  private void save(Playlist playlist) {
    allPlaylists.save(playlist);
  }

  private Playlist playlist(Long memberId, String title) {
    return Playlist.builder()
      .memberId(memberId)
      .title(title)
      .build();
  }
}
