package toolc.yourlist.auth.token.domain;

import lombok.Getter;

@Getter
final class TokenMaterial {
  private final String identifier;
  private final Device device;

  TokenMaterial(String identifier, Device device) {
    this.identifier = identifier;
    this.device = device;
  }
}


