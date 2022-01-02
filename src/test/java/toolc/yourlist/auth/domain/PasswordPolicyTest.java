package toolc.yourlist.auth.domain;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class PasswordPolicyTest {

  @Test
  void non_null() {
    PasswordPolicy nonNull = new PasswordNonNull();

    assertThat(nonNull.matches("Password1!"), is(true));
  }

  @Test
  void should_have_special_character() {
    PasswordPolicy haveSpecialCharacter = new PasswordHaveSpecialCharacter();
    assertThat(haveSpecialCharacter.matches("Password1@"), is(true));
  }

  @Test
  void length_limited_from_6_to_20() {
    PasswordPolicy lengthLimit = new PasswordLengthLimit();

    assertThat(lengthLimit.matches("Password1@"), is(true));
  }

  @Test
  void allow_only_alphabet_or_number_or_special_character() {
    PasswordPolicy allowOnlyAlphabetOrNumberOrSpecialCharacter =
      new AllowOnlyAlphabetOrNumberOrSpecialCharacter();

    assertThat(allowOnlyAlphabetOrNumberOrSpecialCharacter.matches("j1!"),
      is(true));
  }

  @Test
  void should_be_satisfied_all_password_policy() {
    PasswordPolicy allPasswordPolicy = new AllPasswordPolicy();

    assertThat(allPasswordPolicy.matches("PasswordTest1!"), is(true));
  }
}