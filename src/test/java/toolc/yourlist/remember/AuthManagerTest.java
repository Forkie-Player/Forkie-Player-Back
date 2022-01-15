package toolc.yourlist.remember;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthManagerTest {

  AuthManager authManager = new AuthManager();

  @Test
  void registered_visitor_can_not_register_again() {
    var deviceId = "55D154BE-07E6-42FA-832B-D9CF11CE0D6A";

    authManager.registerVisitor(deviceId);
    assertThrows(IllegalArgumentException.class, () -> authManager.registerVisitor(deviceId));
  }
}