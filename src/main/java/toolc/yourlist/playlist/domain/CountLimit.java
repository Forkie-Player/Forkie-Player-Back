package toolc.yourlist.playlist.domain;

class CountLimit implements SavePolicy {
  @Override
  public boolean matches(SaveRequest request) {
    return request.playlistCount() < 5;
  }
}
