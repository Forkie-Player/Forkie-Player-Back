package toolc.yourlist.auth.token.domain;

public interface AccessTokenCreator {
  AccessToken create(String identifier);
}
