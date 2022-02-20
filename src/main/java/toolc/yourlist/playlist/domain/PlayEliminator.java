package toolc.yourlist.playlist.domain;

import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;

@RequiredArgsConstructor
public class PlayEliminator {
  private final AllPlay allPlay;
  private final SequenceUpdater sequenceUpdater;
  private final ChangeThumbnail changeThumbnail;

  @Transactional
  public void delete(ValidRequestForPlay request) {
    var plays = allPlay.readAllBelongsTo(request.get().playlistId());

    sequenceUpdater.updateWithDelete(plays, request.get().sequence());

    changeThumbnail.changeForEmptyPlaylist(request.get().playlistId());
  }
}
