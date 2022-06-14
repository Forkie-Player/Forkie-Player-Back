package toolc.yourlist.playlist.domain;

import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;

@RequiredArgsConstructor
public class PlayAdder {
  private final AllPlay allPlay;
  private final ChangeThumbnail changeThumbnail;

  @Transactional
  public void add(AddPlayRequest request) {
    var playlistSize = allPlay.havingCountOf(request.validRequestForPlaylist().get().id());
    var play = Play.builder()
      .playlistId(request.validRequestForPlaylist().get().id())
      .sequence(playlistSize)
      .info(request.info())
      .time(request.time())
      .channel(request.channel())
      .platform(request.platform())
      .build();

    allPlay.save(play);

    changeThumbnail.changeForMakingFirstPlay(
      request.validRequestForPlaylist().get().id(),
      request.info().thumbnail());
  }
}
