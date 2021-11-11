package toolc.yourlist.runner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "toolc.yourlist")
@EnableJpaRepositories(basePackages = "toolc.yourlist")
@EntityScan(basePackages = "toolc.yourlist")
public class YourlistApplication {

	public static void main(String[] args) {
		SpringApplication.run(YourlistApplication.class, args);
	}

}
