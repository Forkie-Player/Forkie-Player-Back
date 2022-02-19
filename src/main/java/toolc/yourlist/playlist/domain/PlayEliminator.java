package toolc.yourlist.playlist.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PlayEliminator {
  private final AllPlay allPlay;

  public void delete(ValidRequestForPlay request) {
    allPlay.deleteById(request.get().id());
  }
}
