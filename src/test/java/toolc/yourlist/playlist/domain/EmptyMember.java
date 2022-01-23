package toolc.yourlist.playlist.domain;

public class EmptyMember implements AllMember {
  @Override
  public Member findById(Long id) {
    return null;
  }

  @Override
  public boolean exist(Long id) {
    return false;
  }
}
