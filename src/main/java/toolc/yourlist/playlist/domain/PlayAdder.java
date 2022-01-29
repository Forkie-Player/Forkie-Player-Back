package toolc.yourlist.playlist.domain;

import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;

@RequiredArgsConstructor
public class PlayAdder {
  private final AllPlay allPlay;
  private final PlaylistThumbnail playlistThumbnail;

  @Transactional
  public void add(AddPlayRequest request) {
    var playlistSize = allPlay.havingCountOf(request.equalOwnerForPlaylist().playlist().id());
    var play = Play.builder()
      .playlistId(request.equalOwnerForPlaylist().playlist().id())
      .sequence(playlistSize + 1)
      .info(request.info())
      .time(request.time())
      .channel(request.channel())
      .build();

    allPlay.save(play);
    playlistThumbnail.change(
      request.equalOwnerForPlaylist().playlist().id(),
      request.info().thumbnail(),
      playlistSize);
  }
}
