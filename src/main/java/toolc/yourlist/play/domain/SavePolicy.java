package toolc.yourlist.play.domain;

public interface SavePolicy {
  boolean matches(PlaylistSaveRequest request);
}
