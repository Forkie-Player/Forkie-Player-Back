package toolc.yourlist.auth.token.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public final class TokenMaterial {
  private final String identifier;
  private final Device device;

  public TokenMaterial(String identifier, Device device) {
    this.identifier = identifier;
    this.device = device;
  }
}


