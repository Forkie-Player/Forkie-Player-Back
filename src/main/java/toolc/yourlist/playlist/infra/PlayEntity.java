package toolc.yourlist.playlist.infra;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import toolc.yourlist.common.domain.BaseEntity;
import toolc.yourlist.playlist.domain.Play;

import javax.persistence.Entity;
import javax.persistence.Table;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "play")
public class PlayEntity extends BaseEntity {
  private String title;

  private String videoId;

  private long sequence;

  private String thumbnail;

  private Long playlistId;

  private long start;

  private long end;

  private String channelImage;

  private String channelTitle;

  @Builder
  public PlayEntity(
    String title,
    String videoId,
    long sequence,
    String thumbnail,
    Long playlistId,
    long start,
    long end,
    String channelImage,
    String channelTitle) {
    this.title = title;
    this.videoId = videoId;
    this.sequence = sequence;
    this.thumbnail = thumbnail;
    this.playlistId = playlistId;
    this.start = start;
    this.end = end;
    this.channelImage = channelImage;
    this.channelTitle = channelTitle;
  }

  public PlayEntity(Play play) {
    this(
      play.info().title(),
      play.info().videoId(),
      play.sequence(),
      play.info().thumbnail(),
      play.playlistId(),
      play.time().startTime(),
      play.time().endTime(),
      play.channel().image(),
      play.channel().title());
  }
}