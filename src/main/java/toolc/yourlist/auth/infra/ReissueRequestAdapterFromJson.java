package toolc.yourlist.auth.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.auth.domain.InfoForToken;
import toolc.yourlist.auth.domain.ReissueRequest;

@RequiredArgsConstructor
class ReissueRequestAdapterFromJson {
  private final InfoForTokenMakerWithIsPC infoForTokenMakerWithIsPC;


  ReissueRequest mapper(JsonReissueRequest jsonRequest) {

    InfoForToken infoForToken = infoForTokenMakerWithIsPC.makeInfo(jsonRequest.isPC());

    return new ReissueRequest(jsonRequest.accessToken(), jsonRequest.refreshToken(), infoForToken);
  }
}
