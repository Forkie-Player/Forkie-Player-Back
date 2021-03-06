package toolc.yourlist.playlist.infra;

import toolc.yourlist.playlist.domain.*;

import java.util.List;
import java.util.stream.Collectors;

class PlayEntityMapper {
  Play toPlay(PlayEntity entity) {
    return Play.builder()
      .id(entity.id())
      .playlistId(entity.playlistId())
      .sequence(entity.sequence())
      .info(new PlayInfo(entity.title(), entity.videoId(), entity.thumbnail()))
      .time(new PlayTime(entity.start(), entity.end()))
      .channel(new Channel(entity.channelTitle(), entity.channelImage()))
      .platform(entity.platform())
      .build();
  }

  Plays toPlays(List<PlayEntity> entityList) {
    final var list = entityList.stream()
      .map(this::toPlay)
      .collect(Collectors.toList());

    return new Plays(list);
  }
}
