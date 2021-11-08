package toolc.yourlist.play.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.play.domain.PlaylistMapper;
import toolc.yourlist.play.domain.PlaylistVO;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ReadPlaylistVO {
  private final ReadPlaylistEntity readPlaylistEntityList;
  private final ReadThumbnail readThumbnail;
  private final PlaylistMapper mapper = new PlaylistMapper();

  public List<PlaylistVO> readList(Long memberId) {
    return readPlaylistEntityList.readList(memberId)
      .stream()
      .map(playlistEntity ->
        mapper.toPlaylistWithThumbnail(
          playlistEntity,
          readThumbnail.read(playlistEntity.id())
        ))
      .collect(Collectors.toList());
  }
}
