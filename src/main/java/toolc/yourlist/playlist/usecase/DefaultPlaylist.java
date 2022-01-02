package toolc.yourlist.playlist.usecase;

import toolc.yourlist.playlist.domain.AllPlaylists;
import toolc.yourlist.playlist.domain.Playlist;

// TODO: merge 후 MakeDefaultPlaylist 구현
public class DefaultPlaylist {
  AllPlaylists allPlaylists;

  public void make(Long id) {
    allPlaylists.save(getDefault(id));
  }

  private Playlist getDefault(Long id) {
    return Playlist.builder()
      .memberId(id)
      .title("default")
      .build();
  }
}
