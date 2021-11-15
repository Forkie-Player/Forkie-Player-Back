package toolc.yourlist.auth.domain;

interface LoginIdPolicy {
  boolean matches(String rawId);
}

