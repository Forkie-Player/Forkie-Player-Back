package toolc.yourlist.auth.domain.request;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LoginIdFactory {

  private final LoginIdPolicy loginIdPolicy;

  LoginId2 create(String id){
    if(loginIdPolicy.matches(id)){
      return new LoginId2(id);
    };
    throw new IllegalArgumentException("잘못된 LoginId");
  }
}
