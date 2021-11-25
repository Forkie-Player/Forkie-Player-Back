package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.member.domain.AllMember;
import toolc.yourlist.member.infra.Member;
import toolc.yourlist.playlist.domain.SaveRequest;
import toolc.yourlist.playlist.domain.UpdateRequest;

@RequiredArgsConstructor
public class JpaPlaylistAdapter implements PersistingPlaylist {
  private final JpaPlaylistRepository playlistRepository;
  private final AllMember allMember;

  @Override
  public AllPlaylists readAllBelongsTo(String loginId) {
    Member member = allMember.findByLoginId(loginId);

    return new AllPlaylists(playlistRepository.findByMemberId(member.entity().id()));
  }

  @Override
  public void saveByRequest(SaveRequest request) {
    Member member = allMember.findByLoginId(request.loginId());

    playlistRepository.save(PlaylistEntity.builder()
      .memberId(member.entity().id())
      .title(request.title())
      .build());
  }

  @Override
  public void updateTitle(Playlist playlist, UpdateRequest updateRequest) {
    if (!updateRequest.memberId().equals(playlist.memberId())) {
      throw new IllegalArgumentException("영상목록의 주인이 아닙니다.");
    }

    playlist.entity().title(updateRequest.title());
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
