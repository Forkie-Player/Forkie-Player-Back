package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.member.domain.AllMember;
import toolc.yourlist.member.domain.Member;
import toolc.yourlist.playlist.domain.AllPlaylists;
import toolc.yourlist.playlist.domain.Playlist;

import java.util.stream.Collectors;

@RequiredArgsConstructor
public class JpaReadAdapter implements ReadPersisting {
  private final JpaPlaylistRepository playlistRepository;
  private final AllMember allMember;

  @Override
  public AllPlaylists readAllBelongsTo(String loginId) {
    Member member = allMember.findByLoginId(loginId);

    if (member == null) {
      throw new IllegalArgumentException("존재하지 않는 회원입니다.");
    }

    return new AllPlaylists(
      playlistRepository.findByMemberId(member.entity().id())
        .stream()
        .map(PlaylistEntity::toPlaylist)
        .collect(Collectors.toList())
    );
  }

  @Override
  public Playlist readBelongsTo(Long id) {
    return playlistRepository
      .findById(id)
      .orElseThrow(() ->
        new IllegalArgumentException("존재하지 않는 영상 목록입니다."))
      .toPlaylist();
  }

  @Override
  public long havingCountOf(Long memberId) {
    return playlistRepository.countByMemberId(memberId);
  }
}
