package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.playlist.domain.SaveRequest;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class JpaPlaylistAdapter implements Playlist {
  private final JpaPlaylistRepository playlistRepository;

  @Override
  public List<PlaylistEntity> readAllBelongsTo(Long memberId) {
    return playlistRepository.findByMemberId(memberId);
  }

  @Override
  public void saveByRequest(SaveRequest request) {
    playlistRepository.save(PlaylistEntity.builder()
      .memberId(request.memberId())
      .title(request.title())
      .build());
  }

  @Override
  public void updateTitle(PlaylistEntity playlistEntity, String title) {
    playlistEntity.title(title);
    playlistRepository.save(playlistEntity);
  }

  @Override
  public Optional<PlaylistEntity> readBelongsTo(Long id) {
    return playlistRepository.findById(id);
  }
}
