package toolc.yourlist.member.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import toolc.yourlist.member.domain.AllMember;

@Configuration("MemberBeanConfig")
public class BeanConfig {
  @Bean
  AllMember allMember(JpaAllMemberEntity jpaAllMemberEntity) {
    return new AllMemberMapper(jpaAllMemberEntity);
  }
}
