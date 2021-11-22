package toolc.yourlist.auth.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class CheckPassword {
  private final PasswordEncoder passwordEncoder;

  boolean check(Password inputPassword, Member savedMember) {
    return passwordEncoder.matches(inputPassword.raw(), savedMember.password());
  }
}
