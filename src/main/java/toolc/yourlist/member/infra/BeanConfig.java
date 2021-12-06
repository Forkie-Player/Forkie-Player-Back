package toolc.yourlist.member.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class BeanConfig {
  @Bean
  private AllMemberMapper allMemberMapper(JpaAllMember jpaAllMember){
    return new AllMemberMapper(jpaAllMember);
  }
}
