package toolc.yourlist.play.infra;

import java.util.List;

public interface Play {
  List<PlayEntity> readWhatBelongsTo(Long playlistId);
}
