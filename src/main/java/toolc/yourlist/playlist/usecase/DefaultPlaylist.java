package toolc.yourlist.playlist.usecase;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.member.domain.MakeDefaultPlayList;
import toolc.yourlist.member.domain.UserType;
import toolc.yourlist.playlist.domain.AllPlaylists;
import toolc.yourlist.playlist.domain.Playlist;
import toolc.yourlist.playlist.domain.User;

@RequiredArgsConstructor
public class DefaultPlaylist implements MakeDefaultPlayList {
  private final AllPlaylists allPlaylists;

  @Override
  public void make(Long id, UserType type) {
    var user = new User(type, id);

    allPlaylists.save(getDefault(user.code()));
  }

  private Playlist getDefault(String userCode) {
    return Playlist.builder()
      .userCode(userCode)
      .title("default")
      .build();
  }
}
