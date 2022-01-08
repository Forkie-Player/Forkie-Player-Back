package toolc.yourlist.auth.token.domain;

import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.vavr.control.Either;
import toolc.yourlist.auth.domain.ReissueRequest;
import toolc.yourlist.auth.domain.Token;
import toolc.yourlist.auth.domain.TokenProvider;
import toolc.yourlist.auth.domain.TokenVerifier;
import toolc.yourlist.auth.infra.JwtSetConfig;

import static io.vavr.control.Either.left;
import static io.vavr.control.Either.right;

public class JwtVerifier implements TokenVerifier {

  private final JwtParser jwtParser;

  private final RefreshTokenStorage refreshTokenStorage;
  private final TokenProvider tokenProvider;

  public JwtVerifier(JwtSetConfig jwtSetConfig,
                     RefreshTokenStorage refreshTokenStorage,
                     TokenProvider tokenProvider) {
    this.refreshTokenStorage = refreshTokenStorage;
    this.tokenProvider = tokenProvider;
    this.jwtParser = Jwts.parserBuilder().setSigningKey(jwtSetConfig.key()).build();
  }

  @Override
  public Either<String, Token> reissue(ReissueRequest request) {
    Long id = getPk(request.accessToken());

    if (checkExpiration(id, request.refreshToken(), request.isPC()))
      return right(tokenProvider.create(id, request.isPC()));
    else
      return left("refreshToken 이 만료되었습니다.");
  }

  private Long getPk(String accessToken) {
    return Long.parseLong(
      jwtParser.parseClaimsJws(accessToken).getBody().getSubject());
  }

  private boolean checkExpiration(Long id, String refreshToken, boolean isPC) {
    String savedToken = refreshTokenStorage.find(isPC ? "PC" : "APP" + id);
    return refreshToken.equals(savedToken);
  }

}
