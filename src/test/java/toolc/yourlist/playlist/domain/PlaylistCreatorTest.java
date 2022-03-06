package toolc.yourlist.playlist.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import toolc.yourlist.member.domain.UserType;

import static io.vavr.control.Either.left;
import static io.vavr.control.Either.right;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static toolc.yourlist.member.domain.UserType.MEMBER;
import static toolc.yourlist.member.domain.UserType.VISITOR;

@ExtendWith(MockitoExtension.class)
class PlaylistCreatorTest {
  @Test
  void create(@Mock AllPlaylists allPlaylists) {
    var creator = new PlaylistCreator(allPlaylists);
    var request = new SaveRequest(new User(MEMBER, 1L), "My List");
    given(allPlaylists.havingCountOf(request.user())).willReturn(5L);

    var actual = creator.create(request);

    assertThat(actual, is(right(Boolean.TRUE)));
    verify(allPlaylists).havingCountOf(request.user());
  }

  @Test
  void create_exceed_limit(@Mock AllPlaylists allPlaylists) {
    var creator = new PlaylistCreator(allPlaylists);
    var request = new SaveRequest(new User(VISITOR, 1L), "My List");
    given(allPlaylists.havingCountOf(request.user())).willReturn(5L);

    var actual = creator.create(request);

    assertThat(actual, is(left("비회원의 영상 생성 제한을 넘었습니다.")));
    verify(allPlaylists).havingCountOf(request.user());
  }
}