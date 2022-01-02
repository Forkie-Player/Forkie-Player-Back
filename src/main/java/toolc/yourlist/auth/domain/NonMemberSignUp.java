package toolc.yourlist.auth.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class NonMemberSignUp {

  private final NonMemberSave nonMemberSave;
  private final MakeDefaultPlayList makeDefaultPlayList;

  public NonMember singUp(NonMemberSignUpRequest request) {

    NonMember save = nonMemberSave.save(request.deviceId());
    makeDefaultPlayList.make(save.id());

    return save;


    // todo ::
    //  1. 유저가입
    //   1-1 이미 있는지 검증 -- 도메인 영역
    //   1-2
    //  2. 리스트 생성
    //   2-1. 인터페이스 뽑아서 승재 던져주기 (id)
  }
}
