package toolc.yourlist.play.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.play.domain.PlaylistSaveRequest;

import java.util.List;

@RequiredArgsConstructor
public class JpaPlaylistAdapter implements Playlist {
  private final JpaPlaylistRepository playlistRepository;

  @Override
  public List<PlaylistEntity> readWhatBelongsTo(Long memberId) {
    return playlistRepository.findByMemberId(memberId);
  }

  @Override
  public void save(PlaylistSaveRequest request) {
    playlistRepository.save(PlaylistEntity.builder()
      .memberId(request.memberId())
      .title(request.title())
      .build());
  }
}
