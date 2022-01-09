package toolc.yourlist.playlist.play.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import toolc.yourlist.playlist.play.domain.JpaPlayRepository;

public interface SpringDataJPAPlayRepository extends JpaRepository<PlayEntity, Long>, JpaPlayRepository {
}