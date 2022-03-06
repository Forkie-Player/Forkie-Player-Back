package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.playlist.domain.AllPlaylists;
import toolc.yourlist.playlist.domain.Playlist;
import toolc.yourlist.playlist.domain.Playlists;
import toolc.yourlist.playlist.domain.User;
import toolc.yourlist.playlist.domain.exception.NoExistPlaylistException;

import javax.transaction.Transactional;

@RequiredArgsConstructor
class JpaPlaylistAdapter implements AllPlaylists {
  private final JpaPlaylistRepository playlistRepository;
  private final PlaylistEntityMapper mapper = new PlaylistEntityMapper();

  @Override
  public Playlists readAllBelongsTo(User user) {
    return mapper.toPlaylists(
      playlistRepository.findByUserCode(user.code()));
  }

  @Override
  public Playlist readBelongsTo(Long id) {
    return mapper.toPlaylist(getEntity(id));
  }

  @Override
  public long havingCountOf(User user) {
    return playlistRepository.countByUserCode(user.code());
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
    entity.thumbnail(thumbnail);
  }

  @Override
  @Transactional
  public void changeOwnerToMember(User visitor, User member) {
    var entities = playlistRepository.findByUserCode(visitor.code());
    entities.forEach(entity -> entity.userCode(member.code()));
  }

  private PlaylistEntity getEntity(Long playlistId) {
    return playlistRepository.findById(playlistId).orElseThrow(
      NoExistPlaylistException::new);
  }
}
