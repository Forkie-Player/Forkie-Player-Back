package toolc.yourlist.auth.domain;

public final record InfoForToken(AuthExpiration authExpiration, String tokenSavedNamePrefix) {
}
