package toolc.yourlist.auth.domain;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class NonMemberLogin {
  private final AllNonMember allNonMember;
  private final TokenProvider tokenProvider;

  public Token login(NonMemberLoginRequest request) {
    NonMember savedNonMember = allNonMember.findByDeviceId(request.deviceId());

    return tokenProvider.create(savedNonMember.id(), request.device());
  }
}
