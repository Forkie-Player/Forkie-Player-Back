package toolc.yourlist.member.domain;

import java.time.Instant;

public interface TokenSerializer {
  Token makeToken(Long id, Instant accessTokenExpiration, Instant refreshTokenExpiration
    , UserType userType);
}
