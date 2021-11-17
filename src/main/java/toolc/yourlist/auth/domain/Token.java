package toolc.yourlist.auth.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
public final class Token {
  AccessToken accessToken;
  RefreshToken refreshToken;

  public Token(AccessToken accessToken, RefreshToken refreshToken) {
    this.accessToken = accessToken;
    this.refreshToken = refreshToken;
  }
}
