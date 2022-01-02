package toolc.yourlist.auth.domain;

public interface AllMember {
  Member findByLoginId(String loginId);
}
