package toolc.yourlist.auth.domain.request;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface PasswordPolicy {
  boolean matches(String rawPassword);
}

