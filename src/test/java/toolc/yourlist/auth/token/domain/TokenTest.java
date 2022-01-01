package toolc.yourlist.auth.token.domain;

import org.junit.jupiter.api.Test;
import toolc.yourlist.auth.domain.Token;

import java.time.Instant;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class TokenTest {

  @Test
  void equals() {
    Instant expirationTime = Instant.now();

    Token token = new Token(
      "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtZW1iZXIwMDIiLCJhd.LtnIrL4WgUNU2Abpdq2",
      "eyJhbGciOiJIUzUxMiJ9.eyJleHA.31V6KtCI5Rfd-3MdcXd7_OG4A94f2Fb8w_WudcfwB7");

    assertThat(token,
      is(new Token("eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtZW1iZXIwMDIiLCJhd.LtnIrL4WgUNU2Abpdq2",
        "eyJhbGciOiJIUzUxMiJ9.eyJleHA.31V6KtCI5Rfd-3MdcXd7_OG4A94f2Fb8w_WudcfwB7")));
  }

}