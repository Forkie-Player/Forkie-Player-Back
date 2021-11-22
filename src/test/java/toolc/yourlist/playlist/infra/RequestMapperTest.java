package toolc.yourlist.playlist.infra;

import org.junit.jupiter.api.Test;
import toolc.yourlist.member.domain.Member;
import toolc.yourlist.member.domain.MockAllMember;
import toolc.yourlist.playlist.domain.SaveRequest;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static toolc.yourlist.common.infra.JsonResponse.failForBadRequest;

class RequestMapperTest {

  @Test
  void PlaylistSaveRequest로_변환() {
    RequestMapper mapper = new RequestMapper(MockAllMember.builder()
      .findByLoginId(loginId ->
        new Member("oh980225",
          "qwer1234!",
          true))
      .build(),
      MockPersistingPlaylist.builder()
        .havingCountOf(() -> 2L)
        .build());

    JsonSaveRequest jsonSaveRequest = JsonSaveRequest.builder()
      .loginId("oh980225")
      .title("title003")
      .build();

    assertThat(mapper.toSaveRequest(jsonSaveRequest).success(),
      is(SaveRequest.builder()
        .loginId("oh980225")
        .title("title003")
        .isMember(true)
        .playlistCount(2L)
        .build()));
  }

  @Test
  void 변환시_회원존재X() {
    RequestMapper mapper = new RequestMapper(MockAllMember.builder()
      .findByLoginId(loginId -> null)
      .build(),
      MockPersistingPlaylist.builder()
        .build());
    JsonSaveRequest jsonSaveRequest = JsonSaveRequest.builder()
      .loginId("oh980225")
      .title("title003")
      .build();

    var actual = mapper.toSaveRequest(jsonSaveRequest).fail();

    var expected = failForBadRequest("유효하지 않은 loginId입니다.");
    assertThat(actual, is(expected));
  }
}