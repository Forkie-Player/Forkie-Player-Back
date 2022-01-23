package toolc.yourlist;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.springframework.boot.test.context.SpringBootTest;
import toolc.yourlist.runner.SpringBootRunner;

@SpringBootTest(classes = SpringBootRunner.class)
class SpringBootRunnerTests {
	@Test
	void contextLoads() {
	}
}
