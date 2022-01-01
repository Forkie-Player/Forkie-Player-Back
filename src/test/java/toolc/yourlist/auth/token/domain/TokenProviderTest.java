//package toolc.yourlist.auth.token.domain;
//
//import org.junit.jupiter.api.Test;
//import toolc.yourlist.auth.domain.Token;
//import toolc.yourlist.auth.domain.TokenProvider;
//
//import java.time.Instant;
//import java.time.temporal.ChronoUnit;
//
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.is;
//
//
//class TokenProviderTest {
//  Instant testTime = Instant.now().plus(30, ChronoUnit.HOURS);
//
//  @Test
//  void provide_token() {
//    //given
//    TokenProvider tokenProvider =
//      new JwtProvider(
//        new MockAccessTokenCreator(),
//        new MockRefreshTokenCreator());
//
//    TokenMaterial material = new TokenMaterial("jisoo27", Device.PC);
//
//    //when
//    Token actual = tokenProvider.create(material);
//
//    //then
//    Token expected = new Token(
//      "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtZW1iZXIwMDIiLCJhd.LtnIrL4WgUNU2Abpdq2",
//      "eyJhbGciOiJIUzUxMiJ9.eyJleHA.31V6KtCI5Rfd-3MdcXd7_OG4A94f2Fb8w_WudcfwB7");
//
//    assertThat(actual, is(expected));
//  }
//
//  private class MockAccessTokenCreator implements AccessTokenCreator {
//    @Override
//    public AccessToken create(String identifier) {
//      return new AccessToken(identifier, testTime);
//    }
//  }
//
//  private class MockRefreshTokenCreator implements RefreshTokenCreator {
//    @Override
//    public RefreshToken create(Device device) {
//      return new RefreshToken(testTime);
//    }
//  }
//
//}
