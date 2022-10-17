package toolc.yourlist.member.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import toolc.yourlist.member.domain.*;
import toolc.yourlist.member.domain.loginId.AllLoginPolicy;
import toolc.yourlist.member.domain.loginId.LoginIdFactory;
import toolc.yourlist.member.domain.loginId.LoginIdPolicy;
import toolc.yourlist.member.domain.password.AllPasswordPolicy;
import toolc.yourlist.member.domain.password.PasswordFactory;
import toolc.yourlist.member.domain.password.PasswordPolicy;
import toolc.yourlist.member.infra.jwt.JwtToken;
import toolc.yourlist.member.infra.jwt.filter.JwtResolver;

@Configuration
public class BeanConfig {

  @Bean
  LoginIdPolicy loginIdPolicy() {
    return new AllLoginPolicy();
  }

  @Bean
  LoginIdFactory loginIdFactory(LoginIdPolicy loginIdPolicy) {
    return new LoginIdFactory(loginIdPolicy);
  }

  @Bean
  PasswordPolicy passwordPolicy() {
    return new AllPasswordPolicy();
  }

  @Bean
  PasswordFactory passwordFactory(PasswordPolicy passwordPolicy) {
    return new PasswordFactory(passwordPolicy);
  }


  @Bean
  TokenSecretKey tokenSecretKey() {
    return new TokenSecretKey();
  }

  @Bean
  TimeServer timeServer() {
    return new RealTimeServer();
  }

  @Bean
  TokenSerializer tokenSerializer(TokenSecretKey tokenSecretKey) {
    return new JwtToken(tokenSecretKey);
  }

  @Bean
  TokenProvider tokenProvider(TokenReader tokenReader, TimeServer timeServer,
                              TokenSerializer tokenSerializer) {
    return new TokenProvider(tokenReader, timeServer, tokenSerializer);
  }

  @Bean
  TokenReader tokenReader(TokenSecretKey tokenSecretKey) {
    return new TokenReader(tokenSecretKey);
  }

  @Bean
  JwtResolver jwtResolver(TokenSecretKey tokenSecretKey) {
    return new JwtResolver(tokenSecretKey);
  }

  @Bean
  VisitorEntityToDomainAdapter visitorDomainAdapter() {
    return new VisitorEntityToDomainAdapter();
  }

  @Bean
  AllVisitor allVisitor(JpaAllVisitorEntity jpaAllVisitorEntity,
                        VisitorEntityToDomainAdapter visitorEntityToDomainAdapter) {
    return new JpaAllVisitor(jpaAllVisitorEntity, visitorEntityToDomainAdapter);
  }

  @Bean
  MemberEntityToDomainAdapter memberEntityToDomainAdapter(LoginIdFactory loginIdFactory,
                                                          PasswordFactory passwordFactory) {
    return new MemberEntityToDomainAdapter(loginIdFactory, passwordFactory);
  }

  @Bean
  AllMember allMember(JpaAllMemberEntity jpaAllMemberEntity,
                      MemberEntityToDomainAdapter memberEntityToDomainAdapter) {
    return new JpaAllMember(jpaAllMemberEntity, memberEntityToDomainAdapter);
  }

  @Bean
  MemberFinder memberFinder(AllMember allMember) {
    return new MemberFinder(allMember);
  }

  @Bean
  RequestMapperFromJson requestMapperFromJson(LoginIdFactory loginIdFactory,
                                              PasswordFactory passwordFactory) {
    return new RequestMapperFromJson(loginIdFactory, passwordFactory);
  }

  @Bean
  VisitorAuthProvider visitorAuthProvider(TokenProvider tokenProvider,
                                          AllVisitor allVisitor) {
    return new VisitorAuthProvider(tokenProvider, allVisitor);
  }

  @Bean
  WordProvidable wordProvidable() {
    return new WordProvider();
  }

  @Bean
  NicknameGenerator nicknameGenerator(AllMember allMember, WordProvidable wordProvidable) {
    return new NicknameGenerator(allMember, wordProvidable);
  }

  @Bean
  MemberAuthProvider memberAuthProvider(TokenProvider tokenProvider, AllMember allMember, NicknameGenerator nicknameGenerator) {
    return new MemberAuthProvider(tokenProvider, allMember, nicknameGenerator);
  }

  @Bean
  VisitorToMemberChanger visitorToMemberChanger(MemberAuthProvider memberAuthProvider,
                                                AllMember allMember, AllVisitor allVisitor,
                                                PlaylistOwnerChange playlistOwnerChange) {
    return new VisitorToMemberChanger(memberAuthProvider, allMember, allVisitor, playlistOwnerChange);
  }

  @Bean
  OAuthAuthenticationSuccessHandler authAuthenticationSuccessHandler(JpaAllMemberEntity jpaAllMemberEntity, MemberAuthProvider memberAuthProvider) {
    return new OAuthAuthenticationSuccessHandler(jpaAllMemberEntity, memberAuthProvider);
  }

  @Bean
  OAuthAuthenticationFailureHandler authAuthenticationFailureHandler() {
    return new OAuthAuthenticationFailureHandler();
  }

  @Bean
  CustomOidcService oAuthService() {
    return new CustomOidcService();
  }

  @Bean
  NicknameEditor nicknameEditor(AllMember allMember) {
    return new NicknameEditor(allMember);
  }
}
