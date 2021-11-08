package toolc.yourlist;

import toolc.yourlist.play.domain.PlaylistVO;
import toolc.yourlist.play.infra.PlayEntity;
import toolc.yourlist.play.infra.PlaylistEntity;

import java.util.Arrays;
import java.util.List;

public class PlaylistFixture {
  public static PlaylistEntity.PlaylistEntityBuilder playlistEntity() {
    return PlaylistEntity.builder()
      .id(1L)
      .memberId(1L);
  }

  public static PlaylistVO.PlaylistVOBuilder playlist() {
    return PlaylistVO.builder()
      .id(1L)
      .thumbnail("thumbnail");
  }

  public static List<PlaylistEntity> playlistEntityList() {
    return Arrays.asList(
      playlistEntity()
        .build(),
      playlistEntity()
        .id(2L)
        .build(),
      playlistEntity()
        .id(3L)
        .build()
    );
  }
}
