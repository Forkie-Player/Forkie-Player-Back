package toolc.yourlist.auth.domain;

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

    LoginRequest request = new LoginRequest(
      new LoginId("jisoo27"),
      new Password("qwer1234!"), Device.PC);

    //when
    Token actual = tokenProvider.create(request);

    //then
    Token expected = new Token(
      new AccessToken(new LoginId("jisoo27"), testTime),
      new RefreshToken(testTime));

    assertThat(actual, is(expected));
  }

  private class MockAccessTokenCreator implements AccessTokenCreator {
    @Override
    public AccessToken create(LoginId loginId) {
      return new AccessToken(loginId, testTime);
    }
  }

  private class MockRefreshTokenCreator implements RefreshTokenCreator {
    @Override
    public RefreshToken create(Device device) {
      return new RefreshToken(testTime);
    }
  }

}
