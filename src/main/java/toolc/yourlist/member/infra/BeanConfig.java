package toolc.yourlist.member.infra;

import org.springframework.context.annotation.Bean;

public class BeanConfig {
  @Bean
  private AllMemberMapper allMemberMapper(JpaAllMemberEntity jpaAllMemberEntity){
    return new AllMemberMapper(jpaAllMemberEntity);
  }
}
