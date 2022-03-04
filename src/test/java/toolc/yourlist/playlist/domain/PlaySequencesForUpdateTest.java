package toolc.yourlist.playlist.domain;

import org.junit.jupiter.api.Test;
import toolc.yourlist.member.domain.UserType;
import toolc.yourlist.playlist.domain.exception.InvalidSeqException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static toolc.yourlist.member.domain.UserType.MEMBER;

class PlaySequencesForUpdateTest {
  @Test
  void sequence_duplicate() {
    assertThrows(InvalidSeqException.class, () -> new PlaySequencesForUpdate(List.of(
      new PlaySequence(
        new ValidRequestForPlay(
          new User(MEMBER, 1L),
          Playlist.builder()
            .id(1L)
            .userCode("MEMBER_1")
            .title("My List")
            .thumbnail("panda.png")
            .build(),
          Play.builder()
            .id(1L)
            .playlistId(1L)
            .sequence(0L)
            .info(new PlayInfo("So Good Music", "abcd1234", "panda.png"))
            .time(new PlayTime(1000L, 3000L))
            .channel(new Channel("Music man", "man.png"))
            .build()), 0L),
      new PlaySequence(
        new ValidRequestForPlay(
          new User(MEMBER, 1L),
          Playlist.builder()
            .id(1L)
            .userCode("MEMBER_1")
            .title("My List")
            .thumbnail("panda.png")
            .build(),
          Play.builder()
            .id(2L)
            .playlistId(1L)
            .sequence(1L)
            .info(new PlayInfo("So Sad Music", "qwer1234", "puppy.png"))
            .time(new PlayTime(2500L, 3000L))
            .channel(new Channel("Music man", "man.png"))
            .build()), 0L))));
  }

  @Test
  void sequence_not_zero_to_end_idx() {
    assertThrows(InvalidSeqException.class, () -> new PlaySequencesForUpdate(List.of(
      new PlaySequence(
        new ValidRequestForPlay(
          new User(MEMBER, 1L),
          Playlist.builder()
            .id(1L)
            .userCode("MEMBER_1")
            .title("My List")
            .thumbnail("panda.png")
            .build(),
          Play.builder()
            .id(1L)
            .playlistId(1L)
            .sequence(0L)
            .info(new PlayInfo("So Good Music", "abcd1234", "panda.png"))
            .time(new PlayTime(1000L, 3000L))
            .channel(new Channel("Music man", "man.png"))
            .build()), 0L),
      new PlaySequence(
        new ValidRequestForPlay(
          new User(MEMBER, 1L),
          Playlist.builder()
            .id(1L)
            .userCode("MEMBER_1")
            .title("My List")
            .thumbnail("panda.png")
            .build(),
          Play.builder()
            .id(2L)
            .playlistId(1L)
            .sequence(1L)
            .info(new PlayInfo("So Sad Music", "qwer1234", "puppy.png"))
            .time(new PlayTime(2500L, 3000L))
            .channel(new Channel("Music man", "man.png"))
            .build()), 2L))));
  }
}