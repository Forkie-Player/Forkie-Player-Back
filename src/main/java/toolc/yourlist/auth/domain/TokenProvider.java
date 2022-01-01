package toolc.yourlist.auth.domain;

import toolc.yourlist.auth.token.domain.Device;

public interface TokenProvider {
  Token create(Long id, Device device);
}

