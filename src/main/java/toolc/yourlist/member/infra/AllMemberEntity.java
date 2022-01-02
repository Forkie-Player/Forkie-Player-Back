package toolc.yourlist.member.infra;

public interface AllMemberEntity {
  //TODO :: Member Domain 객체 생성시 교체해줘야한다.
  MemberEntity findByLoginId(String loginId);
  MemberEntity save(MemberEntity member);
}