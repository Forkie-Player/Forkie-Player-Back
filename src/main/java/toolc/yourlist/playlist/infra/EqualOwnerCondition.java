package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EqualOwnerCondition {
  private final PersistingPlaylist persistingPlaylist;

  boolean check(Long memberId, Long playlistId) {
    Playlist playlist = persistingPlaylist.readBelongsTo(playlistId);

    return memberId.equals(playlist.entity().memberId());
  }
}
