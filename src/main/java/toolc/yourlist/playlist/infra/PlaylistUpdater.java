package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PlaylistUpdater {
  private final DifferOwnerCondition differOwnerCondition;
  private final UpdatePersisting updatePersisting;

  void updateTitle(Long memberId, Long playlistId, String title) {
    if (differOwnerCondition.check(memberId, playlistId)) {
      throw new IllegalArgumentException("Playlist 소유자의 요청이 아닙니다.");
    }

    updatePersisting.updateTitle(playlistId, title);
  }
}
