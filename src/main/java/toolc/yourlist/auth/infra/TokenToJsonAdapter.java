package toolc.yourlist.auth.infra;

import toolc.yourlist.auth.domain.Token;

public class TokenToJsonAdapter {
  TokenJson toJson(Token token) {
    return new TokenJson(token.accessToken(), token.refreshToken());
  }
}


