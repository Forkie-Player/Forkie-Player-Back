package toolc.yourlist.playlist.infra;

import org.springframework.data.jpa.repository.JpaRepository;

interface SpringDataJPAPlaylistRepository extends JpaRepository<PlaylistEntity, Long>, JpaPlaylistRepository {
}