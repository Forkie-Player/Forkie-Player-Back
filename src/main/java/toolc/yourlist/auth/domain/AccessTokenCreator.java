package toolc.yourlist.auth.domain;

import lombok.RequiredArgsConstructor;

import java.time.Duration;

@RequiredArgsConstructor
class AccessTokenCreator {
  private final CurrentTime currentTime;
  private final Duration EXPIRATION_DATE = Duration.ofMinutes(30);

  AccessToken create(LoginId loginId) {
    return new AccessToken(loginId, currentTime.now().plus(EXPIRATION_DATE));
  }
}
