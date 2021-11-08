package toolc.yourlist;

import toolc.yourlist.play.domain.Playlist;
import toolc.yourlist.play.infra.PlaylistEntity;

public class PlaylistFixture {
  public static PlaylistEntity.PlaylistEntityBuilder playlistEntity() {
    return PlaylistEntity.builder()
      .id(1L)
      .memberId(1L);
  }

  public static Playlist.PlaylistBuilder playlist() {
    return Playlist.builder()
      .id(1L)
      .thumbnail("thumbnail");
  }
}
