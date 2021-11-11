package toolc.yourlist.member.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class BeanConfig {

  @Autowired
  private JpaAllMember jpaAllMember;

  @Bean
  private AllMemberMapper allMemberMapper(){
    return new AllMemberMapper(jpaAllMember);
  }
}
