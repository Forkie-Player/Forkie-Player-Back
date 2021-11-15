package toolc.yourlist;

import toolc.yourlist.play.infra.Play;

import java.util.Arrays;
import java.util.List;

public class PlayFixture {
  public static Play.PlayBuilder play() {
    return Play.builder()
      .sequence(1)
      .thumbnail("thumbnail");
  }

  public static List<Play> playList() {
    return Arrays.asList(
      play()
        .build(),
      play()
        .sequence(2)
        .thumbnail("thumbnail2")
        .build(),
      play()
        .sequence(3)
        .thumbnail("thumbnail3")
        .build()
      );
  }
}
