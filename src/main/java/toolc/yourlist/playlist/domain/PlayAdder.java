package toolc.yourlist.playlist.domain;

import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;

@RequiredArgsConstructor
public class PlayAdder {
  private final AllPlay allPlay;
  private final ChangeThumbnail changeThumbnail;

  @Transactional
  public void add(AddPlayRequest request) {
    var playlistSize = allPlay.havingCountOf(request.validRequestForPlaylist().playlist().id());
    var play = Play.builder()
      .playlistId(request.validRequestForPlaylist().playlist().id())
      .sequence(playlistSize)
      .info(request.info())
      .time(request.time())
      .channel(request.channel())
      .build();

    allPlay.save(play);
    changeThumbnail.changeForMakingFirstPlay(
      request.validRequestForPlaylist().playlist().id(),
      request.info().thumbnail(),
      playlistSize);
  }
}
