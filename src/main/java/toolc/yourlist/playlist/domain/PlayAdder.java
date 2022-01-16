package toolc.yourlist.playlist.domain;

import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;

@RequiredArgsConstructor
public class PlayAdder {
  private final EqualOwnerCondition condition = new EqualOwnerCondition();
  private final AllPlay allPlay;
  private final PlaylistThumbnail playlistThumbnail;

  @Transactional
  public void add(AddPlayRequest request) {
    condition.check(request.member(), request.playlist());

    long playlistSize = allPlay.havingCountOf(request.playlist().id());

    allPlay.save(request.play(), playlistSize);
    playlistThumbnail.change(request.playlist().id(), request.play().thumbnail(), playlistSize);
  }
}
