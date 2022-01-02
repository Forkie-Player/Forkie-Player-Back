package toolc.yourlist.auth.domain;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;

class TokenProviderTest {
  private TokenProvider tokenProvider = new AnyTokenProvider();

  @Test
  void non_null(){

    assertThat(tokenProvider.create(anyLong(), true), is(notNullValue()));

  }


}
