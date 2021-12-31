package toolc.yourlist.member.infra;

public interface AllMemberEntity {
  MemberEntity findByLoginId(String loginId);
  MemberEntity save(MemberEntity member);
}