package toolc.yourlist.playlist.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PlaylistReaderTest {
  @Test
  void belongsTo(@Mock AllPlaylists allPlaylists) {
    var reader = new PlaylistReader(allPlaylists);
    var request = new ReadRequest(
      Member.builder()
        .id(1L)
        .loginId("oh980225")
        .password("qwer1234!")
        .isMember(true)
        .build());
    given(allPlaylists.readAllBelongsTo(request.member().id())).willReturn(
      new Playlists(List.of(
        Playlist.builder()
          .id(1L)
          .memberId(request.member().id())
          .title("My List")
          .thumbnail("panda.png")
          .build(),
        Playlist.builder()
          .id(2L)
          .memberId(request.member().id())
          .title("Good Music")
          .thumbnail("puppy.png")
          .build())));

    var actual = reader.belongsTo(request);

    var expected = new Playlists(List.of(
      Playlist.builder()
        .id(1L)
        .memberId(request.member().id())
        .title("My List")
        .thumbnail("panda.png")
        .build(),
      Playlist.builder()
        .id(2L)
        .memberId(request.member().id())
        .title("Good Music")
        .thumbnail("puppy.png")
        .build()));
    verify(allPlaylists).readAllBelongsTo(request.member().id());
    assertThat(actual, is(expected));
  }
}