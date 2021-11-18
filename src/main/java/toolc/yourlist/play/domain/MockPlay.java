package toolc.yourlist.play.domain;

import lombok.Builder;
import toolc.yourlist.play.infra.Play;
import toolc.yourlist.play.infra.PlayEntity;

import java.util.List;

public final class MockPlay implements Play {
  ReadWhatBelongsTo readWhatBelongsTo;

  @Override
  public List<PlayEntity> readWhatBelongsTo(Long playlistId) {
    return readWhatBelongsTo.done(playlistId);
  }

  @FunctionalInterface
  public interface ReadWhatBelongsTo {
    List<PlayEntity> done(Long playlistId);
  }

  @Builder
  public MockPlay(ReadWhatBelongsTo readWhatBelongsTo) {
    this.readWhatBelongsTo = readWhatBelongsTo;
  }
}
