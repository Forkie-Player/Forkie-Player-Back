package toolc.yourlist;

import toolc.yourlist.play.domain.PlaylistJson;
import toolc.yourlist.play.infra.PlaylistEntity;

import java.util.List;

public class PlaylistFixture {
  public static PlaylistEntity.PlaylistEntityBuilder playlistEntity() {
    return PlaylistEntity.builder()
      .title("title")
      .memberId(1L);
  }

  public static List<PlaylistEntity> playlistEntityList() {
    return List.of(
      playlistEntity().build(),
      playlistEntity().build());
  }

  public static PlaylistJson.PlaylistJsonBuilder playlistJson() {
    return PlaylistJson.builder()
      .id(playlistEntity().build().id())
      .title(playlistEntity().build().title())
      .thumbnail("thumbnail");
  }

  public static List<PlaylistJson> playlistJsonList() {
    return List.of(
      playlistJson().build(),
      playlistJson().build());
  }
}
