package toolc.yourlist.playlist.infra;

import org.junit.jupiter.api.Test;
import toolc.yourlist.member.domain.AllMember;
import toolc.yourlist.member.domain.MockAllMember;
import toolc.yourlist.member.infra.Member;
import toolc.yourlist.member.infra.MemberEntity;
import toolc.yourlist.playlist.domain.UpdateRequest;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class JsonUpdateRequestMapperTest {
  @Test
  void UpdateRequest변환() {
    AllMember allMember = MockAllMember.builder()
      .findByLoginId(loginId -> new Member(
        new MemberEntity("oh980225", "qwer1234!", true)
      ))
      .build();
    PersistingPlaylist persistingPlaylist = MockPersistingPlaylist.builder()
      .readBelongsTo(id -> new Playlist(
        Optional.of(
          PlaylistEntity.builder()
            .memberId(1L)
            .title("My List")
            .build())))
      .build();
    JsonUpdateRequestMapper mapper = new JsonUpdateRequestMapper(
      new MemberExistCondition(allMember),
      new EqualOwnerCondition(persistingPlaylist),
      new PlaylistExistCondition(persistingPlaylist)
    );

    var actual = mapper.toUpdateRequest(JsonUpdateRequest.builder()
      .loginId("oh980225")
      .playlistId(1L)
      .title("New List")
      .build());

    var expected = UpdateRequest.builder()
      .memberId(1L)
      .title("New List")
      .playlistId(1L)
      .build();
    assertThat(actual, is(expected));
  }
}