package toolc.yourlist.auth.domain;

import io.vavr.control.Either;

public interface TokenVerifier {
  Either<String, Token> reissue(ReissueRequest request);
}


