package toolc.yourlist.playlist.infra;

import org.junit.jupiter.api.Test;
import toolc.yourlist.member.domain.AllMember;
import toolc.yourlist.member.domain.MockAllMember;
import toolc.yourlist.member.infra.Member;
import toolc.yourlist.member.infra.MemberEntity;

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
      .findById(id -> new Member(
        new MemberEntity("oh980225", "qwer1234!", true)
      ))
      .build();
    PersistingPlaylist persistingPlaylist = MockPersistingPlaylist.builder()
      .readBelongsTo(id -> new Playlist(
        Optional.of(
          new PlaylistEntity(1L, "My List"))))
      .build();
    JsonUpdateRequestMapper mapper = new JsonUpdateRequestMapper(
      new MemberExistCondition(allMember),
      new EqualOwnerCondition(allMember),
      new PlaylistExistCondition(persistingPlaylist)
    );

    var actual = mapper.toUpdateRequest(JsonUpdateRequest.builder()
      .loginId("oh980225")
      .playlistId(1L)
      .title("New List")
      .build());

    var expected = UpdateRequest.builder()
      .member(new Member(
        new MemberEntity("oh980225", "qwer1234!", true)
      ))
      .title("New List")
      .playlistId(1L)
      .build();
    assertThat(actual.get(), is(expected));
  }

  @Test
  void 회원존재X() {
    AllMember allMember = MockAllMember.builder()
      .findByLoginId(loginId -> new Member(
        Optional.empty()
      ))
      .build();
    PersistingPlaylist persistingPlaylist = MockPersistingPlaylist.builder()
      .readBelongsTo(id -> new Playlist(
        Optional.of(
          new PlaylistEntity(1L, "My List"))))
      .build();
    JsonUpdateRequestMapper mapper = new JsonUpdateRequestMapper(
      new MemberExistCondition(allMember),
      new EqualOwnerCondition(allMember),
      new PlaylistExistCondition(persistingPlaylist)
    );

    var actual = mapper.toUpdateRequest(JsonUpdateRequest.builder()
      .loginId("oh980225")
      .playlistId(1L)
      .title("New List")
      .build());

    var expected = "존재하지 않는 회원입니다.";
    assertThat(actual.getLeft(), is(expected));
  }

  @Test
  void 영상목록_존재X() {
    AllMember allMember = MockAllMember.builder()
      .findByLoginId(loginId -> new Member(
        new MemberEntity("oh980225", "qwer1234!", true)
      ))
      .findById(id -> new Member(
        new MemberEntity("oh980225", "qwer1234!", true)
      ))
      .build();
    PersistingPlaylist persistingPlaylist = MockPersistingPlaylist.builder()
      .readBelongsTo(id -> new Playlist(
        Optional.empty()
      ))
      .build();
    JsonUpdateRequestMapper mapper = new JsonUpdateRequestMapper(
      new MemberExistCondition(allMember),
      new EqualOwnerCondition(allMember),
      new PlaylistExistCondition(persistingPlaylist)
    );

    var actual = mapper.toUpdateRequest(JsonUpdateRequest.builder()
      .loginId("oh980225")
      .playlistId(1L)
      .title("New List")
      .build());

    var expected = "존재하지 않는 영상 목록입니다.";
    assertThat(actual.getLeft(), is(expected));
  }

  @Test
  void 영상목록_주인X() {
    AllMember allMember = MockAllMember.builder()
      .findByLoginId(loginId -> new Member(
        new MemberEntity("oh980225", "qwer1234!", true)
      ))
      .findById(id -> new Member(
        new MemberEntity("oh1263", "abcd1234!", true)
      ))
      .build();
    PersistingPlaylist persistingPlaylist = MockPersistingPlaylist.builder()
      .readBelongsTo(id -> new Playlist(
        Optional.of(
          new PlaylistEntity(1L, "My List"))))
      .build();
    JsonUpdateRequestMapper mapper = new JsonUpdateRequestMapper(
      new MemberExistCondition(allMember),
      new EqualOwnerCondition(allMember),
      new PlaylistExistCondition(persistingPlaylist)
    );

    var actual = mapper.toUpdateRequest(JsonUpdateRequest.builder()
      .loginId("oh980225")
      .playlistId(1L)
      .title("New List")
      .build());

    var expected = "영상목록의 주인이 아닙니다.";
    assertThat(actual.getLeft(), is(expected));
  }
}