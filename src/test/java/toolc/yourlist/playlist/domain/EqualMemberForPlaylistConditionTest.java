package toolc.yourlist.playlist.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class EqualMemberForPlaylistConditionTest {
  @Test
  void 영상목록의_주인X() {
    var condition = new EqualMemberCondition();

    assertThrows(NotOwnerException.class, () -> condition.check(
      Member.builder()
        .id(1L)
        .isMember(true)
        .loginId("oh980225")
        .password("qwer1234!")
        .build(),
      Playlist.builder()
        .id(1L)
        .memberId(2L)
        .title("My List")
        .thumbnail("panda.png")
        .build()
    ));
  }
}