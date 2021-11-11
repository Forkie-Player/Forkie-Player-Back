package toolc.yourlist;

import toolc.yourlist.play.domain.PlaylistJson;
import toolc.yourlist.play.infra.PlaylistEntity;

public class PlaylistFixture {
  public static PlaylistEntity.PlaylistEntityBuilder playlistEntity() {
    return PlaylistEntity.builder()
      .memberId(1L);
  }

  public static PlaylistJson.PlaylistJsonBuilder playlistJson() {
    return PlaylistJson.builder()
      .id(playlistEntity().build().id())
      .thumbnail("thumbnail");
  }
}
