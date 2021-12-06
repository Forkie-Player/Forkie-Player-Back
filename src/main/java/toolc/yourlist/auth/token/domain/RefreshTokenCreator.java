package toolc.yourlist.auth.token.domain;

public interface RefreshTokenCreator {
  RefreshToken create(Device device);
}
