package toolc.yourlist.play.infra;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJPAPlayRepository extends JpaRepository<PlayEntity, Long>, JpaPlayRepository {
}