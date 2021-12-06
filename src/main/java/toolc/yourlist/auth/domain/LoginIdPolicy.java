package toolc.yourlist.auth.domain;

public interface LoginIdPolicy {
  boolean matches(String rawId);
}

