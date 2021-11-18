package toolc.yourlist.auth.domain;

public interface PasswordEncoder {
  String encode(String raw);
}
