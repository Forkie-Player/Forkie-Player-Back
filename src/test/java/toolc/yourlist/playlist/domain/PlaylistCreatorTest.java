package toolc.yourlist.playlist.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static io.vavr.control.Either.left;
import static io.vavr.control.Either.right;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PlaylistCreatorTest {
  @Test
  void create(@Mock AllMember allMember, @Mock AllPlaylists allPlaylists) {
    var creator = new PlaylistCreator(allMember, allPlaylists);
    var request = new SaveRequest(1L, "My List");
    given(allMember.findById(request.memberId())).willReturn(
      Member.builder()
        .id(request.memberId())
        .loginId("oh980225")
        .password("qwer1234!")
        .isMember(true)
        .build());
    given(allPlaylists.havingCountOf(request.memberId())).willReturn(5L);

    var actual = creator.create(request);

    assertThat(actual, is(right(Boolean.TRUE)));
    verify(allMember).findById(request.memberId());
    verify(allPlaylists).havingCountOf(request.memberId());
  }

  @Test
  void create_exceed_limit(@Mock AllMember allMember, @Mock AllPlaylists allPlaylists) {
    var creator = new PlaylistCreator(allMember, allPlaylists);
    var request = new SaveRequest(1L, "My List");
    given(allMember.findById(request.memberId())).willReturn(
      Member.builder()
        .id(request.memberId())
        .loginId("oh980225")
        .password("qwer1234!")
        .isMember(false)
        .build());
    given(allPlaylists.havingCountOf(request.memberId())).willReturn(5L);

    var actual = creator.create(request);

    assertThat(actual, is(left("비회원의 영상 생성 제한을 넘었습니다.")));
    verify(allMember).findById(request.memberId());
    verify(allPlaylists).havingCountOf(request.memberId());
  }
}