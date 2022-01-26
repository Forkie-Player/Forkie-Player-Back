package toolc.yourlist.member.domain.password;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class HaveSpecialCharacterTest {
  @Test
  void should_have_special_character() {
    PasswordPolicy haveSpecialCharacter = new HaveSpecialCharacter();
    assertThat(haveSpecialCharacter.matches("Password1@"), is(true));
  }

}