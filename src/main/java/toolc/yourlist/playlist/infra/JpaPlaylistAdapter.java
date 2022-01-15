package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.playlist.domain.AllPlaylists;
import toolc.yourlist.playlist.domain.ListOfPlaylists;
import toolc.yourlist.playlist.domain.NoExistPlaylistException;
import toolc.yourlist.playlist.domain.Playlist;

import javax.transaction.Transactional;

@RequiredArgsConstructor
class JpaPlaylistAdapter implements AllPlaylists {
  private final JpaPlaylistRepository playlistRepository;
  private final PlaylistEntityMapper mapper = new PlaylistEntityMapper();

  @Override
  public ListOfPlaylists readAllBelongsTo(Long memberId) {
    return mapper.toListOfPlaylists(
      playlistRepository.findByMemberId(memberId)
    );
  }

  @Override
  public Playlist readBelongsTo(Long id) {
    return mapper.toPlaylist(playlistRepository.findById(id));
  }

  @Override
  public boolean exist(Long id) {
    try {
      readBelongsTo(id);
      return true;
    } catch (NoExistPlaylistException e) {
      return false;
    }
  }

  @Override
  public long havingCountOf(Long memberId) {
    return playlistRepository.countByMemberId(memberId);
  }

  @Override
  public void save(Playlist playlist) {
    playlistRepository.save(new PlaylistEntity(playlist));
  }

  @Override
  @Transactional
  public void updateTitleBelongsTo(Long playlistId, String title) {
    var entity = getEntity(playlistId);
    entity.title(title);
  }

  @Override
  public void delete(Playlist playlist) {
    playlistRepository.deleteById(playlist.id());
  }

  @Override
  public void updateThumbnail(Long playlistId, String thumbnail) {
    var entity = getEntity(playlistId);
  }

  private PlaylistEntity getEntity(Long playlistId) {
    return playlistRepository.findById(playlistId).orElseThrow(
      NoExistPlaylistException::new);
  }
}
