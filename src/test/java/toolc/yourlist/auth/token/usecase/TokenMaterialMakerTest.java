package toolc.yourlist.auth.token.usecase;

import org.junit.jupiter.api.Test;
import toolc.yourlist.auth.domain.*;
import toolc.yourlist.auth.token.domain.Device;
import toolc.yourlist.auth.token.domain.TokenMaterial;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


class TokenMaterialMakerTest {

  @Test
  void real_member_login_request_change_token_material() {
    //given
    TokenMaterialMaker maker = new TokenMaterialMaker();
    LoginRequest loginRequest = new LoginRequest(
      loginIdFactory.create("jisoo27"), passwordFactory.create("qwer1234!"),
      Device.PC);

    //when
    TokenMaterial actual = maker.toTokenMaterial(loginRequest);

    //then
    TokenMaterial expected = new TokenMaterial("jisoo27", Device.PC);
    assertThat(actual, is(expected));

  }

  @Test
  void non_member_login_request_change_token_material() {
    //given
    TokenMaterialMaker maker = new TokenMaterialMaker();
    NonMemberLoginRequest loginRequest = new NonMemberLoginRequest(
      "55D154BE-07E6-42FA-832B-D9CF11CE0D6A", Device.PC);

    //when
    TokenMaterial actual = maker.toTokenMaterial(loginRequest);

    //then
    TokenMaterial expected = new TokenMaterial("55D154BE-07E6-42FA-832B-D9CF11CE0D6A", Device.PC);
    assertThat(actual, is(expected));

  }

  LoginIdFactory loginIdFactory = new LoginIdFactory(new LoginIdPolicy() {
    @Override
    public boolean matches(String rawId) {
      return true;
    }
  });

  PasswordFactory passwordFactory = new PasswordFactory(new PasswordPolicy() {
    @Override
    public boolean matches(String rawPassword) {
      return true;
    }
  });

}