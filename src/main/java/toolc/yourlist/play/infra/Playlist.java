package toolc.yourlist.play.infra;

import toolc.yourlist.play.domain.SaveRequest;

import java.util.List;

public interface Playlist {
  List<PlaylistEntity> readWhatBelongsTo(Long memberId);

  void saveByRequest(SaveRequest request);
}
