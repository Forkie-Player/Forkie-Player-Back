package toolc.yourlist.auth.domain;

import java.time.Instant;

public record AuthExpiration(Instant accessTokenExpiration, Instant refreshTokenValidExpiration) {
}
