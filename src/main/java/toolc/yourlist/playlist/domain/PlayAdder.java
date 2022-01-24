package toolc.yourlist.playlist.domain;

import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;

@RequiredArgsConstructor
public class PlayAdder {
  private final AllPlay allPlay;
  private final PlaylistThumbnail playlistThumbnail;

  @Transactional
  public void add(AddPlayRequest request) {
    var playlistSize = allPlay.havingCountOf(request.equalOwner().playlist().id());
    var play = Play.builder()
      .playlistId(request.equalOwner().playlist().id())
      .title(request.info().title())
      .thumbnail(request.info().thumbnail())
      .videoId(request.info().videoId())
      .sequence(playlistSize + 1)
      .playTime(request.time())
      .channel(request.channel())
      .build();

    allPlay.save(play);
    playlistThumbnail.change(request.equalOwner().playlist().id(), request.info().thumbnail(), playlistSize);
  }
}
