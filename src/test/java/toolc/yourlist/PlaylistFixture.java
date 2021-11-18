package toolc.yourlist;

import toolc.yourlist.play.domain.PlaylistJson;
import toolc.yourlist.play.infra.PlaylistEntity;

import java.util.List;

public class PlaylistFixture {
  public static PlaylistEntity.PlaylistEntityBuilder playlist() {
    return PlaylistEntity.builder()
      .title("title")
      .memberId(1L);
  }

  public static List<PlaylistEntity> playlists() {
    return List.of(
      playlist().build(),
      playlist().build());
  }

  public static PlaylistJson.PlaylistJsonBuilder playlistJson() {
    return PlaylistJson.builder()
      .id(playlist().build().id())
      .title(playlist().build().title())
      .thumbnail("thumbnail");
  }

  public static List<PlaylistJson> playlistJsonList() {
    return List.of(
      playlistJson().build(),
      playlistJson().build());
  }
}
