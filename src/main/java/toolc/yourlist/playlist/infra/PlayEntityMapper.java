package toolc.yourlist.playlist.infra;

import toolc.yourlist.playlist.domain.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

class PlayEntityMapper {
  ListOfPlays toListOfPlays(List<PlayEntity> entityList) {
    return new ListOfPlays(entityList.stream()
      .map(entity -> Play.builder()
        .id(entity.id())
        .playlistId(entity.playlistId())
        .sequence(entity.sequence())
        .info(new PlayInfo(entity.title(), entity.videoId(), entity.thumbnail()))
        .time(new PlayTime(entity.start(), entity.end()))
        .channel(new Channel(entity.title(), entity.channelImage()))
        .build())
      .collect(Collectors.toList()));
  }

  Play toPlay(Optional<PlayEntity> optional) {
    if (optional.isEmpty()) {
      throw new NoExistPlayException();
    }

    var entity = optional.get();

    return Play.builder()
      .id(entity.id())
      .playlistId(entity.playlistId())
      .sequence(entity.sequence())
      .info(new PlayInfo(entity.title(), entity.videoId(), entity.thumbnail()))
      .channel(new Channel(entity.channelTitle(), entity.channelImage()))
      .build();
  }
}
