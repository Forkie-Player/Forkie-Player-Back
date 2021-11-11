package toolc.yourlist.auth.domain.request;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LoginIdFactory {

  private final LoginIdPolicy loginIdPolicy;

  LoginId create(String id){
    if(loginIdPolicy.matches(id)){
      return new LoginId(id);
    };
    throw new IllegalArgumentException("잘못된 LoginId");
  }
}
