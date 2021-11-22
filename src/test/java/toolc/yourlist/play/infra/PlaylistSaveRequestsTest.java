package toolc.yourlist.play.infra;

import org.junit.jupiter.api.Test;
import toolc.yourlist.common.domain.ContractViolationException;
import toolc.yourlist.member.infra.MemberEntity;
import toolc.yourlist.member.domain.MockMemberRepository;
import toolc.yourlist.play.domain.MockPlaylistRepository;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static toolc.yourlist.PlaylistFixture.playlists;

class PlaylistSaveRequestsTest {
  PlaylistSaveRequests playlistSaveRequests;

  @Test
  void 멤버가_존재X() {
    playlistSaveRequests = new PlaylistSaveRequests(MockMemberRepository.builder()
      .findById(id -> Optional.empty())
      .build(),
      MockPlaylistRepository.builder()
        .findByMemberId(memberId -> playlists())
        .build());

    assertThrows(ContractViolationException.class, () -> playlistSaveRequests.of(1L, "title"));
  }

  @Test
  void 회원인_경우() {
    List<Playlist> playlistList = playlists();
    playlistSaveRequests = new PlaylistSaveRequests(MockMemberRepository.builder()
      .findById(id ->
        Optional.of(new MemberEntity("loginId", "password", true)))
      .build(),
      MockPlaylistRepository.builder()
        .findByMemberId(memberId -> playlistList)
        .build());

    assertThat(
      playlistSaveRequests.of(1L, "title"),
      is(new PlaylistSaveRequest(
        1L,
        "title",
        true, playlistList.size())));
  }

  @Test
  void 비회원_경우() {
    List<Playlist> playlistList = playlists();
    playlistSaveRequests = new PlaylistSaveRequests(MockMemberRepository.builder()
      .findById(id ->
        Optional.of(new MemberEntity("loginId", "password", false)))
      .build(),
      MockPlaylistRepository.builder()
        .findByMemberId(memberId -> playlistList)
        .build());

    assertThat(
      playlistSaveRequests.of(1L, "title"),
      is(new PlaylistSaveRequest(
        1L,
        "title",
        false, playlistList.size())));
  }
}