package toolc.yourlist.playlist.domain;

import org.junit.jupiter.api.Test;

class PlayAdderTest {
  @Test
  void add() {
    var adder = new PlayAdder(new MockAllPlay(), new MockAllPlaylists());

    adder.add(new AddPlayRequest(
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
        .title("Funny Video")
        .videoId("abcd1234")
        .thumbnail("panda.png")
        .playlistId(1L)
        .playTime(new PlayTime(10000L, 13000L))
        .channel(new Channel("happy man", "smile.png"))
        .build()));
  }
}