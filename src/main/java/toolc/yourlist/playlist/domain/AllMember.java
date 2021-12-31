package toolc.yourlist.playlist.domain;

public interface AllMember {
  Member findById(Long id);

  boolean exist(Long id);
}
