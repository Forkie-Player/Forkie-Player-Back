package toolc.yourlist.playlist.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TimeUpdater {
  private final AllPlay allPlay;

  public void update(TimeUpdateRequest request) {
    allPlay.updateTime(request.validRequestForPlay().get().id(), request.time());
  }
}
