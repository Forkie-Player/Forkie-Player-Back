package toolc.yourlist.playlist.usecase;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.member.domain.MakeDefaultPlayList;
import toolc.yourlist.playlist.domain.AllPlaylists;
import toolc.yourlist.playlist.domain.Playlist;

@RequiredArgsConstructor
public class DefaultPlaylist implements MakeDefaultPlayList {
  private final AllPlaylists allPlaylists;

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
