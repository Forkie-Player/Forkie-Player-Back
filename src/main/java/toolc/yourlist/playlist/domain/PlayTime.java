package toolc.yourlist.playlist.domain;

import toolc.yourlist.playlist.domain.exception.ExceedEndTimeException;
import toolc.yourlist.playlist.domain.exception.NegativeException;

public record PlayTime(Long startTime, Long endTime) {
  public PlayTime {
    if (startTime < 0 || endTime < 0) {
      throw new NegativeException();
    }

    if (startTime > endTime) {
      throw new ExceedEndTimeException();
    }
  }
}
