package toolc.yourlist.member.domain;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.common.domain.VoidResult;

@RequiredArgsConstructor
public class NicknameEditor {
  private final AllMember allMember;

  public VoidResult edit(Long id, String nickname) {
    if (allMember.isExistByNickname(nickname)) {
      return VoidResult.ofWithError("중복된 닉네임이 존재합니다.");
    }

    allMember.editNickname(id, nickname);
    return VoidResult.of();
  }
}
