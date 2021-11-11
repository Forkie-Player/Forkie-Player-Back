package toolc.yourlist.auth.domain;

import toolc.yourlist.auth.domain.request.LoginRequest;

public class MemberLogin {
  Token login(LoginRequest request) {
    return new Token();
  }
}
