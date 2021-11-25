package toolc.yourlist.playlist.infra;

import org.junit.jupiter.api.Test;
import toolc.yourlist.member.domain.MockAllMember;
import toolc.yourlist.member.infra.Member;
import toolc.yourlist.member.infra.MemberEntity;
import toolc.yourlist.playlist.domain.SaveRequest;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class JsonSaveRequestMapperTest {

  @Test
  void PlaylistSaveRequest로_변환() {
    JsonSaveRequestMapper mapper = new JsonSaveRequestMapper(
      MockPersistingPlaylist.builder()
        .havingCountOf(() -> 2L)
        .build(),
      new MemberExistCondition(
        MockAllMember.builder()
          .findByLoginId(loginId ->
            new Member(
              new MemberEntity("oh980225",
                "qwer1234!",
                true)))
          .build()));

    JsonSaveRequest jsonSaveRequest = JsonSaveRequest.builder()
      .loginId("oh980225")
      .title("title003")
      .build();

    assertThat(mapper.toSaveRequest(jsonSaveRequest).get(),
      is(SaveRequest.builder()
        .loginId("oh980225")
        .title("title003")
        .isMember(true)
        .playlistCount(2L)
        .build()));
  }

  @Test
  void 변환시_회원존재X() {
    JsonSaveRequestMapper mapper = new JsonSaveRequestMapper(
      MockPersistingPlaylist.builder()
        .havingCountOf(() -> 2L)
        .build(),
      new MemberExistCondition(
        MockAllMember.builder()
          .findByLoginId(loginId -> new Member(Optional.empty()))
          .build())
      );
    JsonSaveRequest jsonSaveRequest = JsonSaveRequest.builder()
      .loginId("oh980225")
      .title("title003")
      .build();

    var actual = mapper.toSaveRequest(jsonSaveRequest).getLeft();

    assertThat(actual, is("존재하지 않는 회원입니다."));
  }
}