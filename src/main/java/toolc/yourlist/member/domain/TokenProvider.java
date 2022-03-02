package toolc.yourlist.member.domain;

import lombok.RequiredArgsConstructor;

import java.time.Duration;
import java.time.Instant;
import java.time.Period;

@RequiredArgsConstructor
public class TokenProvider {

  private final TokenReader tokenReader;
  private final TimeServer timeServer;
  private final TokenSerializer tokenSerializer;

  public Token reissue(String accessToken, String refreshToken, boolean isPC) {
    TokenUserInfo payload = tokenReader.getPayload(accessToken);
    return makeToken(payload.id(), isPC, payload.userType());
  }

  public Token makeToken(Long id, boolean isPC, UserType userType) {
    Instant nowTime = timeServer.nowTime();

    Duration accessTokenDuration = Duration.ofMinutes(30);
    Instant accessTokenExpiration = nowTime.plus(accessTokenDuration);
    Period refreshTokenValidDuration = isPC ? Period.ofDays(30) : Period.ofDays(7);
    Instant refreshTokenExpiration = nowTime.plus(refreshTokenValidDuration);

    return tokenSerializer.makeToken(id, accessTokenExpiration, refreshTokenExpiration, userType);

  }

}

