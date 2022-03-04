package toolc.yourlist.playlist.usecase;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.member.domain.AuthenticationUser;
import toolc.yourlist.member.domain.MakeDefaultPlayList;
import toolc.yourlist.playlist.domain.AllPlaylists;
import toolc.yourlist.playlist.domain.Playlist;
import toolc.yourlist.playlist.domain.User;

@RequiredArgsConstructor
public class DefaultPlaylist implements MakeDefaultPlayList {
  private final AllPlaylists allPlaylists;

  @Override
  public void make(AuthenticationUser authenticationUser) {
    var user = new User(authenticationUser);

    allPlaylists.save(getDefault(user.code()));
  }

  private Playlist getDefault(String userCode) {
    return Playlist.builder()
      .userCode(userCode)
      .title("default")
      .build();
  }
}
