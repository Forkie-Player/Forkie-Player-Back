package toolc.yourlist.playlist.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SequenceUpdaterTest {

  @Test
  void update() {
    var updater = new SequenceUpdater();
    var request = new PlaySequencesForUpdate(
      List.of(
        new PlaySequence(
          new ValidRequestForPlay(
            Member.builder()
              .id(1L)
              .loginId("oh980225")
              .password("qwer1234!")
              .isMember(true)
              .build(),
            Playlist.builder()
              .id(1L)
              .memberId(1L)
              .title("My List")
              .thumbnail("panda.png")
              .build(),
            Play.builder()
              .id(1L)
              .playlistId(1L)
              .sequence(1L)
              .info(new PlayInfo("So Good Music", "abcd1234", "panda.png"))
              .time(new PlayTime(1000L, 3000L))
              .channel(new Channel("Music man", "man.png"))
              .build()), 2L),
        new PlaySequence(
          new ValidRequestForPlay(
            Member.builder()
              .id(1L)
              .loginId("oh980225")
              .password("qwer1234!")
              .isMember(true)
              .build(),
            Playlist.builder()
              .id(1L)
              .memberId(1L)
              .title("My List")
              .thumbnail("panda.png")
              .build(),
            Play.builder()
              .id(2L)
              .playlistId(1L)
              .sequence(2L)
              .info(new PlayInfo("So Sad Music", "abcd1234", "puppyu.png"))
              .time(new PlayTime(2000L, 3000L))
              .channel(new Channel("Music man", "man.png"))
              .build()), 1L)));

    updater.update(request);
  }
}