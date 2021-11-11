package toolc.yourlist.member.domain;

public interface AllMember {
  Member findByLoginId(String loginId);
  Member save(Member member);
}
