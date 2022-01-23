package toolc.yourlist.playlist.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import toolc.yourlist.playlist.domain.JpaPlayRepository;

public interface SpringDataJPAPlayRepository extends JpaRepository<PlayEntity, Long>, JpaPlayRepository {
}