package toolc.yourlist.member.domain.loginId;

public class AllLoginPolicy implements LoginIdPolicy {
  private final LoginIdPolicy nonNull = new NonNull();
  private final LoginIdPolicy lengthLimit = new LengthLimit();
  private final LoginIdPolicy includeSingleAtSign = new IncludeSingleAtSign();

  @Override
  public boolean matches(String rawId) {
    return nonNull.matches(rawId) && lengthLimit.matches(rawId) && includeSingleAtSign.matches(rawId);
  }
}
