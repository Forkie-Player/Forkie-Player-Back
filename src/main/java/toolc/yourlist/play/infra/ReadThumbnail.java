package toolc.yourlist.play.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.play.domain.PlayRepository;

import java.util.List;

@RequiredArgsConstructor
public class ReadThumbnail {
  private final PlayRepository playRepository;

  String read(Long playlistId) {
    List<PlayEntity> playEntityList = playRepository.findByPlaylistId(playlistId);
    return null;
  }
}
