package toolc.yourlist.auth.domain;


public record LoginRequest(LoginId loginId, Password password, AuthExpiration authExpiration,
                           String TokenSaveNamePrefix) {
}
