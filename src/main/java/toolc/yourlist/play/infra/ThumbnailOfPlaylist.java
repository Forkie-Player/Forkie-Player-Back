package toolc.yourlist.play.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.play.domain.PlayRepository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ThumbnailOfPlaylist {
  private final PlayRepository playRepository;

  String find(Long playlistId) {
    List<Play> list = playRepository.findByPlaylistId(playlistId)
      .stream()
      .filter(playEntity -> playEntity.sequence() == 1)
      .collect(Collectors.toList());

    if (list.size() == 0) {
      return null;
    }

    if (list.size() != 1) {
      throw new IllegalArgumentException();
    }

    return list.get(0).thumbnail();
  }
}
