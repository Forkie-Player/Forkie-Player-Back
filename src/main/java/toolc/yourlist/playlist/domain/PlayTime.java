package toolc.yourlist.playlist.domain;

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
