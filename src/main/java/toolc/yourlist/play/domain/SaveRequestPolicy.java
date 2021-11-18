package toolc.yourlist.play.domain;

public interface SaveRequestPolicy {
  boolean matches(PlaylistSaveRequest request);
}
