package toolc.yourlist.auth.domain;


import lombok.RequiredArgsConstructor;
import toolc.yourlist.auth.token.domain.Token;
import toolc.yourlist.auth.token.usecase.TokenMaterialMaker;
import toolc.yourlist.auth.token.domain.TokenProvider;

@RequiredArgsConstructor
public class NonMemberLogin {
  private final AllNonMember allNonMember;
  private final TokenMaterialMaker tokenMaterialMaker;
  private final TokenProvider tokenProvider;

  public Token login(NonMemberLoginRequest request) {
    NonMember savedNonMember = allNonMember.findByDeviceId(request.deviceId());

    return tokenProvider.create(tokenMaterialMaker.toTokenMaterial(request));
  }
}
