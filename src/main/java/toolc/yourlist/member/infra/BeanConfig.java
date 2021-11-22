package toolc.yourlist.member.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class BeanConfig {

  @Autowired
  private JpaAllMemberEntity jpaAllMemberEntity;

  @Bean
  private AllMemberEntityMapper allMemberMapper(){
    return new AllMemberEntityMapper(jpaAllMemberEntity);
  }
}
