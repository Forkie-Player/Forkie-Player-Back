package toolc.yourlist.auth.domain.request;

public interface PasswordPolicy {
  boolean matches(String rawPassword);
}

