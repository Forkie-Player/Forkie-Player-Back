package toolc.yourlist.remember;

import java.util.HashMap;
import java.util.Map;

public class AuthManager {

  Map<String, Long> visitorsStorage = new HashMap<>();
  Long id = 1L;

  void registerVisitor(String uuid) {
    if (visitorsStorage.containsKey(uuid)) throw new IllegalArgumentException();
    visitorsStorage.put(uuid, id++);
  }

  Token getVisitorToken(String uuid, boolean isPc){
    return new Token("accessToken", "refreshToken");
  }
}
