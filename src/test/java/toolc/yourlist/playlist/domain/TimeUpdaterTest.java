package toolc.yourlist.playlist.domain;

import org.junit.jupiter.api.Test;

class TimeUpdaterTest {
  @Test
  void update() {
    var updater = new TimeUpdater();

    var request = new TimeUpdateRequest(1L, 1L, 2000L, 4000L);

    updater.update(request);
  }
}