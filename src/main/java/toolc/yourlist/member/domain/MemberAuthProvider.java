package toolc.yourlist.member.domain;

import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import toolc.yourlist.member.infra.FileLoader;

import java.util.List;

import static io.vavr.control.Either.left;
import static io.vavr.control.Either.right;

@RequiredArgsConstructor
public class MemberAuthProvider {
  private static final String ADJECTIVE_FILE_PATH = "src/main/resources/adjective.txt";
  private static final String NOUN_FILE_PATH = "src/main/resources/noun.txt";

  private final TokenProvider tokenProvider;
  private final AllMember allMember;
  private final NicknameGenerator nicknameGenerator;

  private final List<String> ADJECTIVE = FileLoader.toStringList(ADJECTIVE_FILE_PATH);
  private final List<String> NOUN = FileLoader.toStringList(NOUN_FILE_PATH);

  public Either<String, Token> registerMember(MemberRegisterAndLoginRequest request) {
    if (allMember.isExistByLoginId(request.loginId())) {
      return left("Already register Member");
    } else {
      allMember.registerMember(
        request.loginId(),
        request.password(),
        nicknameGenerator.generate(ADJECTIVE, NOUN),
        request.provider());
      return right(getMemberToken(request).get());
    }
  }

  public Either<String, Token> getMemberToken(MemberRegisterAndLoginRequest request) {
    Long id = allMember.findIdByLoginId(request.loginId());
    return right(tokenProvider.makeToken(id, request.isPC(), UserType.MEMBER));
  }
}