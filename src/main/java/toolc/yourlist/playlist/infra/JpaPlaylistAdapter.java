package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.member.domain.AllMember;
import toolc.yourlist.member.infra.Member;
import toolc.yourlist.playlist.domain.Playlist;
import toolc.yourlist.playlist.domain.SavePolicy;
import toolc.yourlist.playlist.domain.SaveRequest;

@RequiredArgsConstructor
public class JpaPlaylistAdapter implements PersistingPlaylist {
  private final JpaPlaylistRepository playlistRepository;
  private final AllMember allMember;
  private final SavePolicy savePolicy;

  @Override
  public AllPlaylists readAllBelongsTo(String loginId) {
    Member member = allMember.findByLoginId(loginId);

    return new AllPlaylists(playlistRepository.findByMemberId(member.entity().id()));
  }

  @Override
  public void saveByRequest(SaveRequest request) {
    if (!savePolicy.matches(request)) {
      throw new IllegalArgumentException("[비회원] 생성 갯수 초과");
    }

    Member member = allMember.findByLoginId(request.loginId());

    playlistRepository.save(new PlaylistEntity(
      member.entity().id(),
      request.title()));
  }

  @Override
  public void updateTitle(Playlist playlist, UpdateRequest request) {
    if (!request.member().equals(allMember.findById(playlist.memberId()))) {
      throw new IllegalArgumentException("영상목록의 주인이 아닙니다.");
    }

    playlist.entity().title(request.title());
    playlistRepository.save(playlist.entity());
  }

  @Override
  public Playlist readBelongsTo(Long id) {
    return new Playlist(playlistRepository.findById(id));
  }

  @Override
  public long havingCountOf(Long memberId) {
    return playlistRepository.countByMemberId(memberId);
  }
}
