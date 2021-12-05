package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.playlist.domain.UpdatePlaylist;
import toolc.yourlist.playlist.domain.UpdateRequest;

@RequiredArgsConstructor
final class PlaylistUpdater {
  private final UpdatePlaylist updatePlaylist;
  private final OwnerPolicy ownerPolicy;

  void updateTitle(UpdateRequest request) {
    if (!ownerPolicy.check(request.memberId(), request.playlistId())) {
      throw new IllegalArgumentException("Playlist 소유자의 요청이 아닙니다.");
    }

    updatePlaylist.updateTitle(request.playlistId(), request.title());
  }
}
