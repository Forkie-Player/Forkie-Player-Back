package toolc.yourlist.playlist.infra;

import org.junit.jupiter.api.Test;
import toolc.yourlist.member.domain.Member;
import toolc.yourlist.member.domain.MockAllMember;
import toolc.yourlist.playlist.domain.MockPlaylist;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static toolc.yourlist.PlaylistFixture.playlists;
import static toolc.yourlist.RequestFixture.jsonSaveRequest;
import static toolc.yourlist.RequestFixture.saveRequest;

class RequestMapperTest {
  RequestMapper mapper;

  @Test
  void PlaylistSaveRequest로_변환() {
    mapper = new RequestMapper(MockAllMember.builder()
      .findByLoginId(loginId ->
        new Member("loginId",
          "password",
          true))
      .build(),
      MockPlaylist.builder()
        .readWhatBelongsTo(memberId -> playlists())
        .build());

    JsonSaveRequest jsonSaveRequest = jsonSaveRequest().build();

    assertThat(mapper.toSaveRequest(jsonSaveRequest),
      is(saveRequest()
        .isMember(true)
        .playlistCount(playlists().size())
        .build()));
  }

  @Test
  void 변환시_회원존재X() {
    mapper = new RequestMapper(MockAllMember.builder()
      .findByLoginId(loginId -> null)
      .build(),
      MockPlaylist.builder()
        .build());

    JsonSaveRequest jsonSaveRequest = jsonSaveRequest().build();

    assertThrows(IllegalArgumentException.class, () -> mapper.toSaveRequest(jsonSaveRequest));
  }
}