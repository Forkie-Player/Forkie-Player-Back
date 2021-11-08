package toolc.yourlist.play.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.play.domain.PlaylistRepository;

import java.util.List;

@RequiredArgsConstructor
public class ReadPlaylistEntity {
  private final PlaylistRepository playlistRepository;

  List<PlaylistEntity> readList(Long memberId) {
    return playlistRepository.findByMemberId(memberId);
  }
}
