package toolc.yourlist.remember;

import java.util.HashMap;
import java.util.Map;

public class AuthManager {

  Map<String, Long> visitorsStorage = new HashMap<>();
  Long id = 1L;

  void registerVisitor(String deviceId) {
    if (visitorsStorage.containsKey(deviceId)) throw new IllegalArgumentException();
    visitorsStorage.put(deviceId, id++);
  }
}
