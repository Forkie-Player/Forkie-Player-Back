package toolc.yourlist.playlist.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

// TODO: Mockito이용해서 오케스트레이션 -> 함수의 콜을 확인하는 테스트 필요
class PlaylistReaderTest {
  @Test
  void belongsTo() {
    var allPlaylists = new MockAllPlaylists();
    var reader = new PlaylistReader(allPlaylists);
    var request = new ReadRequest(Member.builder()
      .id(1L)
      .loginId("oh980225")
      .password("qwer1234!")
      .isMember(true)
      .build());

    var actual = reader.belongsTo(request).get();

    var expected = new ListOfPlaylists(List.of(Playlist.builder()
        .id(1L)
        .memberId(1L)
        .title("My List")
        .thumbnail("panda.png")
        .build(),
      Playlist.builder()
        .id(2L)
        .memberId(1L)
        .title("Good Music")
        .thumbnail("puppy.png")
        .build()));
    assertThat(actual, is(expected));
  }
}