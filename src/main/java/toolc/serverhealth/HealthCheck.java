package toolc.serverhealth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/health")
public class HealthCheck {

  @GetMapping()
  public ResponseEntity<?> healthCheck() {
    return ResponseEntity.ok("health Check Success");
  }
}
