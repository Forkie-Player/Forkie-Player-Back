package toolc.yourlist.auth.domain;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;

class TokenProviderTest {
  private TokenProvider tokenProvider = new AnyTokenProvider();

  @Test
  void non_null() {
    AuthExpiration authExpiration = new AuthExpiration(Instant.now().plus(30, ChronoUnit.MINUTES)
      , Instant.now().plus(60, ChronoUnit.MINUTES));

    Long id = 321L;
    assertThat(tokenProvider.create(id, authExpiration, "PC" + id), is(notNullValue()));

  }


}
