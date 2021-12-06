package toolc.yourlist.auth.token.domain;

import lombok.RequiredArgsConstructor;

import java.time.Duration;

@RequiredArgsConstructor
public class AccessTokenCreatorImpl implements AccessTokenCreator {
  private final CurrentTime currentTime;
  private final Duration EXPIRATION_DATE = Duration.ofMinutes(30);

  public AccessToken create(String identifier) {
    return new AccessToken(identifier, currentTime.now().plus(EXPIRATION_DATE));
  }
}
