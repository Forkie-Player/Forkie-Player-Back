package toolc.yourlist.member.domain;

public record TokenReissueRequest(String accessToken, String refreshToken, boolean isPC) {

}
