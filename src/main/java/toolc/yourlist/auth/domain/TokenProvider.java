package toolc.yourlist.auth.domain;

public interface TokenProvider {
  Token create(LoginRequest request);
}


