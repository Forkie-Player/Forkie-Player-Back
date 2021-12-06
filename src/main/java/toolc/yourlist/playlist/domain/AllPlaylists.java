package toolc.yourlist.playlist.domain;

import java.util.Optional;

public interface AllPlaylists {
  ListOfPlaylists readAllBelongsTo(Long memberId);

  Optional<Playlist> readBelongsTo(Long id);

  long havingCountOf(Long memberId);

  void save(Playlist playlist);

  void updateTitleBelongsTo(Long playlistId, String title);
}
