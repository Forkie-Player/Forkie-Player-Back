package toolc.yourlist.play.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import toolc.yourlist.play.domain.PlaylistRepository;

public interface SpringDataJPAPlaylistRepository extends JpaRepository<Playlist, Long>, PlaylistRepository {
}
