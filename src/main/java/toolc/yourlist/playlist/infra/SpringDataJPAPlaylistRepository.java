package toolc.yourlist.playlist.infra;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJPAPlaylistRepository extends JpaRepository<PlaylistEntity, Long>, JpaPlaylistRepository {
}