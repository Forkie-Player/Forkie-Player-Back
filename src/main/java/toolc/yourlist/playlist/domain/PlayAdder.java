package toolc.yourlist.playlist.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PlayAdder {
  private final EqualOwnerCondition condition = new EqualOwnerCondition();
  private final AllPlay allPlay;
  private final AllPlaylists allPlaylists;

  // TODO: 리팩토링 필요할 듯
  public void add(AddPlayRequest request) {
    condition.check(request.member(), request.playlist());

    long playlistSize = allPlay.havingCountOf(request.playlist().id());

    allPlay.save(request.play(), playlistSize);

    if (playlistSize == 0) {
      allPlaylists.updateThumbnail(request.playlist().id(), request.play().thumbnail());
    }
  }
}
