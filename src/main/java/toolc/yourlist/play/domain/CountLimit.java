package toolc.yourlist.play.domain;

class CountLimit implements SaveRequestPolicy {
  @Override
  public boolean matches(PlaylistSaveRequest request) {
    return request.playlistCount() < 5;
  }
}
