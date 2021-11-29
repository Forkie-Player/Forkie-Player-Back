package toolc.yourlist.playlist.infra;

import toolc.yourlist.playlist.domain.SaveRequest;

interface SavePersisting {
  void saveByRequest(SaveRequest request);
}
