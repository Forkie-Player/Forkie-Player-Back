package toolc.yourlist.play.infra;

import toolc.yourlist.play.domain.PlaylistSaveRequest;

import java.util.List;

public interface Playlist {
  List<PlaylistEntity> readWhatBelongsTo(Long memberId);

  void save(PlaylistSaveRequest request);
}
