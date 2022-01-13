package toolc.yourlist.playlist.infra;

import org.junit.jupiter.api.Test;
import toolc.yourlist.playlist.domain.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class JsonAddPlayRequestMapperTest {
  @Test
  void toAddPlayRequest() {
    var mapper = new JsonAddPlayRequestMapper(new MockAllMember(), new MockAllPlaylists());

    var actual = new AddPlayRequest(Member.builder()
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
        .playTime(new PlayTime(10000L, 13000L))
        .channel(new Channel("happy man", "smile.png"))
        .build());

    assertThat(actual, is(mapper.toAddPlayRequest(
      JsonAddPlayRequest.builder()
        .memberId(1L)
        .playlistId(1L)
        .title("Funny Video")
        .videoId("abcd1234")
        .startTime(10000L)
        .endTime(13000L)
        .thumbnail("panda.png")
        .channelTitle("happy man")
        .channelImg("smile.png")
        .build())));
  }
}