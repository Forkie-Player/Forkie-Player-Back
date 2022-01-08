package toolc.yourlist.auth.token.domain;

import java.util.HashMap;
import java.util.Map;

public class RefreshTokenStorage {
  Map<String, String> storage = new HashMap<>();

  public String find(String tokenName) {
    return storage.get(tokenName);
  }
}
