package toolc.yourlist.auth.domain;

import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class AccessTokenTest {


  @Test
  void equals() {
    Instant expirationTime = Instant.now();

    assertThat(new AccessToken("loginid1", expirationTime),
      is(new AccessToken("loginid1", expirationTime)));
  }
}