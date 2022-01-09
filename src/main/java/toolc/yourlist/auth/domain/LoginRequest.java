package toolc.yourlist.auth.domain;


public record LoginRequest(LoginId loginId, Password password, InfoForToken infoForToken) {
}
