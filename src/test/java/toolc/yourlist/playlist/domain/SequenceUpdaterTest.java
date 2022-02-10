package toolc.yourlist.playlist.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SequenceUpdaterTest {

  @Test
  void update() {
    var updater = new SequenceUpdater();
//    var request = new SequenceUpdateRequest(List.of(new ValidRequestForPlay(
//      Member.builder()
//        .id(1L)
//        .loginId("oh980225")
//        .password("qwer1234!")
//        .isMember(true)
//        .build(),
//      Playlist.builder()
//        .id(1L)
//        .memberId(1L)
//        .title("My List")
//        .thumbnail("panda.png")
//        .build(),
//      Play.builder()
//        .id(1L)
//        .playlistId(1L)
//        .sequence(1L)
//        .info(new PlayInfo("So Good Music", "abcd1234", "panda.png"))
//        .time(new PlayTime(1000L, 3000L))
//        .channel(new Channel("Music man", "man.png"))
//        .build())), new PlaySequences());
//
//    updater.update(request);
  }
}