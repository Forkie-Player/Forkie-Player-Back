package toolc.yourlist.auth.domain;

import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class TokenTest {

  @Test
  void equals() {
    Instant expirationTime = Instant.now();
    AccessToken accessToken = new AccessToken("loginid1", expirationTime);
    RefreshToken refreshToken = new RefreshToken(expirationTime);

    assertThat(new Token(accessToken, refreshToken), is(new Token(accessToken, refreshToken)));
  }

}