package toolc.yourlist.member.domain;

public interface AllMember {
  MemberEntity findByLoginId(String loginId);
  MemberEntity save(MemberEntity member);
}
