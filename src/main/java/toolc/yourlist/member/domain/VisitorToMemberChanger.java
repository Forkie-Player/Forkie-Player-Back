package toolc.yourlist.member.domain;

import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import toolc.yourlist.member.infra.Provider;

import static io.vavr.control.Either.left;

@RequiredArgsConstructor
public class VisitorToMemberChanger {

  private final MemberAuthProvider memberAuthProvider;
  private final AllMember allMember;
  private final AllVisitor allVisitor;
  private final PlaylistOwnerChange playlistOwnerChange;

  public Either<String, Token> changeToMember(VisitorToMemberChangeRequest request) {
    if (allVisitor.isNotExistByUUID(request.uuid())) {
      return left("Not exist visitor");
    }
    var token = memberAuthProvider.registerMember(new MemberRegisterAndLoginRequest(
      request.loginId(), request.password(), request.isPC(), Provider.LOCAL));

    var oldVisitorId = allVisitor.findIdByUUID(request.uuid());
    var newMemberId = allMember.findIdByLoginId(request.loginId());

    playlistOwnerChange.changeOwner(oldVisitorId, newMemberId);

    allVisitor.deleteByUUID(request.uuid());
    return token;
  }

}



