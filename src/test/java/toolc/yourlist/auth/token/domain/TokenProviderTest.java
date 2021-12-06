package toolc.yourlist.auth.token.domain;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


class TokenProviderTest {
  Instant testTime = Instant.now().plus(30, ChronoUnit.HOURS);

  @Test
  void provide_token() {
    //given
    TokenProvider tokenProvider =
      new TokenProviderImpl(
        new MockAccessTokenCreator(),
        new MockRefreshTokenCreator());

    TokenMaterial material = new TokenMaterial("jisoo27", Device.PC);

    //when
    Token actual = tokenProvider.create(material);

    //then
    Token expected = new Token(
      new AccessToken("jisoo27", testTime),
      new RefreshToken(testTime));

    assertThat(actual, is(expected));
  }

  private class MockAccessTokenCreator implements AccessTokenCreator {
    @Override
    public AccessToken create(String identifier) {
      return new AccessToken(identifier, testTime);
    }
  }

  private class MockRefreshTokenCreator implements RefreshTokenCreator {
    @Override
    public RefreshToken create(Device device) {
      return new RefreshToken(testTime);
    }
  }

}
