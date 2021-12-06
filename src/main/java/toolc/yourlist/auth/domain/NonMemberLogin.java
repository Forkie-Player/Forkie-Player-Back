package toolc.yourlist.auth.domain;


import lombok.RequiredArgsConstructor;
import toolc.yourlist.auth.token.domain.Token;
import toolc.yourlist.auth.token.usecase.TokenMaterialMaker;
import toolc.yourlist.auth.token.domain.TokenProvider;

@RequiredArgsConstructor
class NonMemberLogin {
  private final AllNonMember allNonMember;
  private final TokenMaterialMaker tokenMaterialMaker;
  private final TokenProvider tokenProvider;

  Token login(NonMemberLoginRequest request) {
    //todo : 토큰
    NonMember savedNonMember = allNonMember.findByDeviceId(request.deviceId());

    return tokenProvider.create(tokenMaterialMaker.toTokenMaterial(request));
  }
}
