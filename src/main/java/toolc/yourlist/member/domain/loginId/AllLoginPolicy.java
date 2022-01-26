package toolc.yourlist.member.domain.loginId;

public class AllLoginPolicy implements LoginIdPolicy {
  private final LoginIdPolicy nonNull = new NonNull();
  private final LoginIdPolicy allowOnlyLowerCaseOrNumber = new AllowLowerCaseOrNumber();
  private final LoginIdPolicy lengthLimit = new LengthLimit();
  private final LoginIdPolicy startLowerCase = new StartLowerCase();

  @Override
  public boolean matches(String rawId) {
    return nonNull.matches(rawId) && allowOnlyLowerCaseOrNumber.matches(rawId) &&
      lengthLimit.matches(rawId) && startLowerCase.matches(rawId);
  }
}
