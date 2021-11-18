package toolc.yourlist.playlist.infra;

import toolc.yourlist.playlist.domain.SaveRequest;

import java.util.List;

public interface Playlist {
  List<PlaylistEntity> readWhatBelongsTo(Long memberId);

  void saveByRequest(SaveRequest request);
}
