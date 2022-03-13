package toolc.yourlist.runner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "toolc")
@EnableJpaRepositories(basePackages = "toolc.yourlist")
@EnableJpaAuditing
@EntityScan(basePackages = "toolc.yourlist")
public class SpringBootRunner {
  public static void main(String[] args) {
    SpringApplication.run(SpringBootRunner.class, args);
  }
}
