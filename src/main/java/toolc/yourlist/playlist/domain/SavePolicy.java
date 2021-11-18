package toolc.yourlist.playlist.domain;

public interface SavePolicy {
  boolean matches(SaveRequest request);
}
