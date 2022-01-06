package toolc.yourlist.play.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import toolc.yourlist.play.domain.JpaPlayRepository;

public interface SpringDataJPAPlayRepository extends JpaRepository<PlayEntity, Long>, JpaPlayRepository {
}