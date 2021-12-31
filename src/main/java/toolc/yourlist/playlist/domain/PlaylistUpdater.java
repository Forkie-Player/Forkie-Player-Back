package toolc.yourlist.playlist.domain;

import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PlaylistUpdater {
  private final AllPlaylists allPlaylists;
  private final EqualOwnerCondition equalCondition = new EqualOwnerCondition();

  public Either<String, Boolean> updateTitle(UpdateRequest request) {
    if (!equalCondition.check(request.member(), request.playlist())) {
      return Either.left("Playlist 소유자의 요청이 아닙니다.");
    }

    allPlaylists.updateTitleBelongsTo(request.playlist().id(), request.title());
    return Either.right(Boolean.TRUE);
  }
}
