package toolc.yourlist.auth.domain;


public record ReissueRequest(String accessToken, String refreshToken,
                             InfoForToken infoForToken) {
}
