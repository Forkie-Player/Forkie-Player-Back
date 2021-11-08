package toolc.yourlist.play.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.play.domain.PlaylistRepository;

import java.util.List;

@RequiredArgsConstructor
public class ReadPlaylist {
  private final PlaylistRepository playlistRepository;

  List<PlaylistEntity> read(Long memberId) {
    return playlistRepository.findByMemberId(memberId);
  }
}
