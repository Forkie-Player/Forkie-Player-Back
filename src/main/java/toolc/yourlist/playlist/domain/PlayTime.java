package toolc.yourlist.playlist.domain;

public record PlayTime(Long startTime, Long endTime) {
  public PlayTime {
    if (startTime > endTime) {
      throw new ExceedEndTimeException();
    }
  }
}
