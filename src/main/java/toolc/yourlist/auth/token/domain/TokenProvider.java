package toolc.yourlist.auth.token.domain;

public interface TokenProvider {
  Token create(TokenMaterial tokenMaterial);
}

