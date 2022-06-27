package toolc.yourlist.playlist.domain;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PlaylistReader {
  private final AllPlaylists allPlaylists;
  private final AllPlay allPlay;

  // TODO: 1급 컬렉션으로 묶을지 고민 -> 묶는다면 Playlists 내의 로직과 유사한데 그 로직을 따로 뺄지도 고민
  public List<PlaylistWithCount> belongsTo(User user) {
    var playlists = allPlaylists.readAllBelongsTo(user);
    return playlists.map(playlist -> new PlaylistWithCount(playlist, allPlay.havingCountOf(playlist.id()))).toList();
  }
}
