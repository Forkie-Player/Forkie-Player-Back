package toolc.yourlist.auth.domain.request;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PasswordFactory {

  private final PasswordPolicy passwordPolicy;

  Password create(String password){
    if(passwordPolicy.matches(password)){
      return new Password(password);
    };
    throw new IllegalArgumentException("잘못된 Password");
  }
}
