package toolc.yourlist.playlist.domain;

import org.junit.jupiter.api.Test;
import toolc.yourlist.playlist.domain.exception.DuplicateIdInListException;
import toolc.yourlist.playlist.domain.exception.InvalidSeqException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class PlaySequencesForUpdateTest {
  @Test
  void sequence_duplicate() {
    assertThrows(InvalidSeqException.class, () -> new PlaySequencesForUpdate(List.of(
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
            .sequence(0L)
            .info(new PlayInfo("So Good Music", "abcd1234", "panda.png"))
            .time(new PlayTime(1000L, 3000L))
            .channel(new Channel("Music man", "man.png"))
            .build()), 0L),
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
            .sequence(0L)
            .info(new PlayInfo("So Good Music", "abcd1234", "panda.png"))
            .time(new PlayTime(1000L, 3000L))
            .channel(new Channel("Music man", "man.png"))
            .build()), 0L),
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
            .sequence(1L)
            .info(new PlayInfo("So Sad Music", "qwer1234", "puppy.png"))
            .time(new PlayTime(2500L, 3000L))
            .channel(new Channel("Music man", "man.png"))
            .build()), 2L))));
  }

  @Test
  void duplicateId() {
    assertThrows(DuplicateIdInListException.class, () -> new PlaySequencesForUpdate(List.of(
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
            .sequence(0L)
            .info(new PlayInfo("So Good Music", "abcd1234", "panda.png"))
            .time(new PlayTime(1000L, 3000L))
            .channel(new Channel("Music man", "man.png"))
            .build()), 1L),
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
            .info(new PlayInfo("So Sad Music", "qwer1234", "puppy.png"))
            .time(new PlayTime(2500L, 3000L))
            .channel(new Channel("Music man", "man.png"))
            .build()), 0L))));
  }
}