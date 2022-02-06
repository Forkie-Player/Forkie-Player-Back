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
  TokenProvider tokenProvider(TokenSecretKey tokenSecretKey, TimeServer timeServer) {
    return new TokenProvider(tokenSecretKey, timeServer);
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
  RequestMapperFromJson requestMapperFromJson(LoginIdFactory loginIdFactory,
                                              PasswordFactory passwordFactory) {
    return new RequestMapperFromJson(loginIdFactory, passwordFactory);
  }

  @Bean
  VisitorAuthProvider visitorAuthProvider(TokenProvider tokenProvider, TokenReader tokenReader,
                                          AllVisitor allVisitor) {
    return new VisitorAuthProvider(tokenProvider, tokenReader, allVisitor);
  }

  @Bean
  MemberAuthProvider memberAuthProvider(TokenProvider tokenProvider, TokenReader tokenReader,
                                        AllMember allMember) {
    return new MemberAuthProvider(tokenProvider, tokenReader, allMember);
  }
}
