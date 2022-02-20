package toolc.yourlist.member.domain.password;

public class AllPasswordPolicy implements PasswordPolicy {

  private final PasswordPolicy allowOnlyAlphabetOrNumberOrSpecialCharacter =
    new AllowAlphabetOrNumberOrSpecialCharacter();
  private final PasswordPolicy nonNull = new NonNull();
  private final PasswordPolicy haveSpecialCharacter =
    new HaveSpecialCharacter();
  private final PasswordPolicy lengthLimit = new LengthLimit();

  @Override
  public boolean matches(String rawPassword) {
    return allowOnlyAlphabetOrNumberOrSpecialCharacter.matches(rawPassword) &&
      nonNull.matches(rawPassword) && haveSpecialCharacter.matches(rawPassword) &&
      lengthLimit.matches(rawPassword);
  }
}
