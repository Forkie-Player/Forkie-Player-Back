package toolc.yourlist.auth.token.domain;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class TokenMaterialTest {

  @Test
  void equals() {
    TokenMaterial material = new TokenMaterial("jisoo27", Device.PC);

    assertThat(material, is(new TokenMaterial("jisoo27", Device.PC)));
  }

}