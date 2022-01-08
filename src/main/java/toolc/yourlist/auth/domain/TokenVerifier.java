package toolc.yourlist.auth.domain;

import io.vavr.control.Either;

public interface TokenVerifier{
  Either<String, Token> reissue(String accessToken, String refreshToken, boolean isPc);
}


