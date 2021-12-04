package toolc.yourlist.auth.domain;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.auth.infra.NomMemberSaveEntity;

@RequiredArgsConstructor
public class NonMemberSignUp {

  private final NomMemberSaveEntity nomMemberSaveEntity;

  NonMember signUp(String nonMemberId) {

    return nomMemberSaveEntity.save(new NonMember(nonMemberId));
  }
}
