package toolc.yourlist.auth.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import toolc.yourlist.auth.domain.*;
import toolc.yourlist.auth.token.domain.*;
import toolc.yourlist.member.infra.JpaAllMemberEntity;


@Configuration
public class BeanConfig {

  @Bean
  LoginIdFactory loginIdFactory() {
    return new LoginIdFactory(new AllLoginPolicy());
  }

  @Bean
  PasswordFactory passwordFactory() {
    return new PasswordFactory(new AllPasswordPolicy());
  }

  @Bean
  RealLoginRequestMapperFromJson realLoginRequestMapperFromJson(
    LoginIdFactory loginIdFactory,
    PasswordFactory passwordFactory,
    InfoForTokenMakerWithIsPC infoForTokenMakerWithIsPC) {
    return new RealLoginRequestMapperFromJson(loginIdFactory, passwordFactory,
      infoForTokenMakerWithIsPC);
  }

  @Bean
  NonLoginRequestMapperFromJson nonLoginRequestMapperFromJson(InfoForTokenMakerWithIsPC infoForTokenMakerWithIsPC) {
    return new NonLoginRequestMapperFromJson(infoForTokenMakerWithIsPC);
  }

  @Bean
  NonMemberSignUpRequestMapperFromJson nonMemberSignUpRequestMapperFromJson() {
    return new NonMemberSignUpRequestMapperFromJson();
  }

  CurrentTimeServer currentTimeServer = new RealTimeServer();

  @Bean
  TokenExpirationConfig expirationConfig() {
    return new TokenExpirationConfig(currentTimeServer);
  }

  @Autowired
  JwtSetConfigSecretKeyYamlAdapter jwtSetConfigSecretKeyYamlAdapter;


  @Autowired
  JpaAllMemberEntity jpaAllMemberEntity;

  @Bean
  AllMember allMember() {
    return new JpaAllMember(jpaAllMemberEntity, new MemberDomainAdapter());
  }

  @Bean
  AllNonMember allNonMember() {
    return new JpaAllNonMember(jpaAllMemberEntity, new NonMemberDomainAdapter());
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new PasswordEncoderSpringAdapter();
  }

  @Bean
  public CheckPassword checkPassword() {
    return new CheckPassword(passwordEncoder());
  }

  @Bean
  public TokenProvider tokenProvider(TokenExpirationConfig tokenExpirationConfig) {
    return new JwtProvider(jwtSetConfigSecretKeyYamlAdapter.toJwtSetConfig(),
      refreshTokenStorage());
  }

  @Bean
  public MemberLogin memberLogin(TokenProvider tokenProvider) {
    return new MemberLogin(allMember(), tokenProvider, checkPassword());
  }

  @Bean
  public NonMemberLogin nonMemberLogin(TokenProvider tokenProvider) {
    return new NonMemberLogin(allNonMember(), tokenProvider);
  }

  @Bean
  public NonMemberSave nonMemberSave() {
    return new NonMemberSave(allNonMember());
  }

  @Bean
  public NonMemberSignUp nonMemberSignUp(MakeDefaultPlayList makeDefaultPlayList) {
    return new NonMemberSignUp(nonMemberSave(), makeDefaultPlayList);
  }

  @Bean
  public RefreshTokenStorage refreshTokenStorage() {
    return new RefreshTokenStorage();
  }

  @Bean
  public TokenVerifier tokenVerifier(TokenProvider tokenProvider) {
    return new JwtVerifier(jwtSetConfigSecretKeyYamlAdapter.toJwtSetConfig(),
      refreshTokenStorage(), tokenProvider);
  }

  @Bean
  public TokenToJsonAdapter tokenToJsonAdapter() {
    return new TokenToJsonAdapter();
  }

  @Bean
  public InfoForTokenMakerWithIsPC infoForTokenMakerWithIsPC(TokenExpirationConfig tokenExpirationConfig) {
    return new InfoForTokenMakerWithIsPC(tokenExpirationConfig);
  }

  @Bean
  public ReissueRequestAdapterFromJson reissueRequestAdapterFromJson(
    InfoForTokenMakerWithIsPC infoForTokenMakerWithIsPC) {
    return new ReissueRequestAdapterFromJson(infoForTokenMakerWithIsPC);
  }
}