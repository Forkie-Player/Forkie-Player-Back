package toolc.yourlist.member.domain;

public interface AllMember {
  Member findByLoginId(String loginId);

  Member findById(Long id);

  boolean exist(Long id);
}
