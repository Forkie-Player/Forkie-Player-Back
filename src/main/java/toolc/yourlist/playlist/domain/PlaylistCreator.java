package toolc.yourlist.playlist.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PlaylistCreator {
  private final AllPlaylists allPlaylists;

  public void create(SaveRequest request) {
    save(playlist(request.user(), request.title()));
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
