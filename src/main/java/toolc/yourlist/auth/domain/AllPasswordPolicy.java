package toolc.yourlist.auth.domain;

class AllPasswordPolicy implements PasswordPolicy {

  private final PasswordPolicy allowOnlyAlphabetOrNumberOrSpecialCharacter = new AllowOnlyAlphabetOrNumberOrSpecialCharacter();
  private final PasswordPolicy nonNull = new PasswordNonNull();
  private final PasswordPolicy haveSpecialCharacter = new PasswordHaveSpecialCharacter();
  private final PasswordPolicy lengthLimit = new PasswordLengthLimit();

  @Override
  public boolean matches(String rawPassword) {
    return allowOnlyAlphabetOrNumberOrSpecialCharacter.matches(rawPassword) &&
      nonNull.matches(rawPassword) && haveSpecialCharacter.matches(rawPassword) &&
      lengthLimit.matches(rawPassword);
  }
}
