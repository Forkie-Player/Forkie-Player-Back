package toolc.yourlist.playlist.infra;

import toolc.yourlist.playlist.domain.Playlist;

interface SavePersisting {
  void save(Playlist playlist);
}
