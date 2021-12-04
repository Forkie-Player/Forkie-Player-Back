package toolc.yourlist.auth.domain;

public interface RefreshTokenCreator {
  RefreshToken create(Device device);
}
