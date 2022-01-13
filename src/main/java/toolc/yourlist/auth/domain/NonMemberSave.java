package toolc.yourlist.auth.domain;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class NonMemberSave {

  private final AllNonMember allNonMember;

  NonMember save(String deviceId) {
    return allNonMember.save(new NonMember(deviceId));
  }
}
