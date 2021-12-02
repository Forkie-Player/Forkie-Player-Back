package toolc.yourlist.auth.domain;

public interface AccessTokenCreator {
  AccessToken create(String identifier);
}
