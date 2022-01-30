package toolc.yourlist.playlist.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayTimeTest {
  @Test
  void constructor_exceed_end_time() {
    Long startTime = 13000L;
    Long endTime = 10000L;

    assertThrows(ExceedEndTimeException.class, () -> new PlayTime(startTime, endTime));
  }

  @Test
  void constructor_negative_time() {
    Long startTime = -13000L;
    Long endTime = 10000L;

    assertThrows(NegativeException.class, () -> new PlayTime(startTime, endTime));
  }
}