package toolc.yourlist.playlist.infra;

import toolc.yourlist.playlist.domain.*;

import java.util.List;
import java.util.stream.Collectors;

class PlayEntityMapper {
  ListOfPlays toListOfPlays(List<PlayEntity> entityList) {
    return new ListOfPlays(entityList.stream()
      .map(entity -> Play.builder()
        .id(entity.id())
        .playlistId(entity.playlistId())
        .title(entity.title())
        .playTime(new PlayTime(entity.start(), entity.end()))
        .channel(new Channel(entity.title(), entity.channelImage()))
        .thumbnail(entity.thumbnail())
        .videoId(entity.videoId())
        .build())
      .collect(Collectors.toList()));
  }
}
