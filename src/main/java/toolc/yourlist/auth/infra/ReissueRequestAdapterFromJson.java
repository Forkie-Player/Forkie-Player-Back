package toolc.yourlist.auth.infra;

import toolc.yourlist.auth.domain.ReissueRequest;

class ReissueRequestAdapterFromJson {
  ReissueRequest mapper(JsonReissueRequest jsonRequest) {
    return new ReissueRequest(jsonRequest.accessToken(), jsonRequest.refreshToken(),
      jsonRequest.isPC());
  }
}
