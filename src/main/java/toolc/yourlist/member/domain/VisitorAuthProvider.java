package toolc.yourlist.member.domain;

import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;

import java.time.Period;

import static io.vavr.control.Either.left;
import static io.vavr.control.Either.right;

@RequiredArgsConstructor
public class VisitorAuthProvider {

  private final TokenProvider tokenProvider;
  private final AllVisitor allVisitor;

  public Either<String, Token> registerVisitor(VisitorRegisterAndLoginRequest request) {
    if (allVisitor.isExistByUUID(request.uuid())) {
      return left("Already registered uuid");
    }
    allVisitor.registerVisitor(request.uuid());
    return right(getVisitorToken(request).get());
  }

  public Either<String, Token> getVisitorToken(VisitorRegisterAndLoginRequest request) {
    if (allVisitor.isNotExistByUUID(request.uuid())) {
      return left("Unregistered visitor");
    } else {
      Long id = allVisitor.findIdByUUID(request.uuid());

      return right(tokenProvider.makeToken(id, request.isPC(), UserType.VISITOR));
    }
  }
}

