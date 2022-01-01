package toolc.yourlist.auth.domain;

class MockPasswordEncoder implements PasswordEncoder {

  @Override
  public String encode(String raw) {
    return "encoded" + raw;
  }

  @Override
  public boolean matches(CharSequence rawPassword, String encodedPassword) {
    return false;
  }

  public MockPasswordEncoder() {
  }
}
