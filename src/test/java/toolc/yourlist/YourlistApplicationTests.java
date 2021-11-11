package toolc.yourlist;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import toolc.yourlist.runner.YourlistApplication;

@SpringBootTest(classes = YourlistApplication.class)
class YourlistApplicationTests {
	@Test
	void contextLoads() {
	}
}
