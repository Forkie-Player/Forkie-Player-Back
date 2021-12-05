package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.member.domain.AllMember;
import toolc.yourlist.member.domain.Member;
import toolc.yourlist.playlist.domain.ListOfPlaylists;
import toolc.yourlist.playlist.domain.Playlist;
import toolc.yourlist.playlist.domain.ReadPlaylist;

import java.util.stream.Collectors;

@RequiredArgsConstructor
public class JpaReadAdapter implements ReadPlaylist {
  private final JpaPlaylistRepository playlistRepository;
  private final AllMember allMember;

  @Override
  public ListOfPlaylists allBelongsTo(Long memberId) {
    Member member = allMember.findById(memberId);

    return new ListOfPlaylists(
      playlistRepository.findByMemberId(member.id())
        .stream()
        .map(PlaylistEntity::toPlaylist)
        .collect(Collectors.toList())
    );
  }

  @Override
  public Playlist belongsTo(Long id) {
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
