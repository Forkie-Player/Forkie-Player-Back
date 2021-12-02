package toolc.yourlist.auth.domain;

interface TokenProvider {
  Token create(LoginRequest request);
}


