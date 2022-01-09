package toolc.yourlist.auth.token.domain;

import java.util.HashMap;
import java.util.Map;

public class RefreshTokenStorage {
  private Map<String, String> storage = new HashMap<>();

  public String find(String tokenName) {
    return storage.get(tokenName);
  }

  public void save(String tokenName, String refreshToken){
    storage.put(tokenName, refreshToken);
  }
}
