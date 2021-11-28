package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.member.domain.AllMember;
import toolc.yourlist.member.infra.Member;
import toolc.yourlist.playlist.domain.AllPlaylists;
import toolc.yourlist.playlist.domain.Playlist;
import toolc.yourlist.playlist.domain.SavePolicy;
import toolc.yourlist.playlist.domain.SaveRequest;

import java.util.stream.Collectors;

@RequiredArgsConstructor
public class JpaPlaylistAdapter implements PersistingPlaylist {
  private final JpaPlaylistRepository playlistRepository;
  private final AllMember allMember;
  private final SavePolicy savePolicy;

  @Override
  public AllPlaylists readAllBelongsTo(String loginId) {
    Member member = allMember.findByLoginId(loginId);

    return new AllPlaylists(
      playlistRepository.findByMemberId(member.entity().id())
        .stream()
        .map(PlaylistEntity::toPlaylist)
        .collect(Collectors.toList())
    );
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
  public void updateTitle(UpdateRequest request) {
    PlaylistEntity entity = playlistRepository
      .findById(request.playlistId())
      .orElseThrow(() ->
        new IllegalArgumentException("존재하지 않는 영상 목록입니다."));

    if (!request.member().equals(allMember.findById(entity.memberId()))) {
      throw new IllegalArgumentException("영상목록의 주인이 아닙니다.");
    }

    entity.title(request.title());
    playlistRepository.save(entity);
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
