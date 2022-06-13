package toolc.yourlist.playlist.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PlaylistCreator {
  private final AllPlaylists allPlaylists;

  public Playlist create(SaveRequest request) {
    return allPlaylists.save(playlist(request.user(), request.title()));
  }

  private Playlist playlist(User user, String title) {
    return Playlist.builder()
      .userCode(user.code())
      .title(title)
      .build();
  }
}
