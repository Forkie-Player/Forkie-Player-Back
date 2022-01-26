package toolc.yourlist.member.domain.password;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class AllowAlphabetOrNumberOrSpecialCharacterTest {
  @Test
  void allow_only_alphabet_or_number_or_special_character() {
    PasswordPolicy allowOnlyAlphabetOrNumberOrSpecialCharacter =
      new AllowAlphabetOrNumberOrSpecialCharacter();

    assertThat(allowOnlyAlphabetOrNumberOrSpecialCharacter.matches("j1!"),
      is(true));
  }
}