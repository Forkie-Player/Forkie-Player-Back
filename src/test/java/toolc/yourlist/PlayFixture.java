package toolc.yourlist;

import toolc.yourlist.play.infra.PlayEntity;

import java.util.Arrays;
import java.util.List;

public class PlayFixture {
  public static PlayEntity.PlayEntityBuilder playEntity() {
    return PlayEntity.builder()
      .sequence(1)
      .thumbnail("thumbnail");
  }

  public static List<PlayEntity> playEntityList() {
    return Arrays.asList(
      playEntity()
        .build(),
      playEntity()
        .sequence(2)
        .thumbnail("thumbnail2")
        .build(),
      playEntity()
        .sequence(3)
        .thumbnail("thumbnail3")
        .build()
      );
  }
}
