package toolc.yourlist.auth.domain;


public record ReissueRequest(String accessToken, String refreshToken,
                             AuthExpiration authExpiration,
                             String tokenSaveNamePrefix) {
}
