package toolc.yourlist.play.infra;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJPAPlaylistRepository extends JpaRepository<PlaylistEntity, Long>, JpaPlaylistRepository {
}
