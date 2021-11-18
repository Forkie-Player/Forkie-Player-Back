package toolc.yourlist.play.domain;

class CountLimit implements SavePolicy {
  @Override
  public boolean matches(SaveRequest request) {
    return request.playlistCount() < 5;
  }
}
