package toolc.yourlist.play.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.play.domain.PlayRepository;
import toolc.yourlist.play.domain.Playlist;
import toolc.yourlist.play.domain.PlaylistMapper;
import toolc.yourlist.play.domain.PlaylistRepository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class PlaylistService {
  private final PlaylistRepository playlistRepository;
  private final PlayRepository playRepository;

  public List<Playlist> readList(Long memberId) {
    ReadPlaylist readPlaylist = new ReadPlaylist(playlistRepository);
    ReadThumbnail readThumbnail = new ReadThumbnail(playRepository);
    PlaylistMapper mapper = new PlaylistMapper();

    return readPlaylist.read(memberId)
      .stream()
      .map(playlistEntity ->
        mapper.toPlaylistWithThumbnail(
          playlistEntity,
          readThumbnail.read(playlistEntity.id())
        ))
      .collect(Collectors.toList());
  }
}
