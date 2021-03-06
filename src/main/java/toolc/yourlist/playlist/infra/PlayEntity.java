package toolc.yourlist.playlist.infra;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import toolc.yourlist.common.domain.BaseEntity;
import toolc.yourlist.playlist.domain.Platform;
import toolc.yourlist.playlist.domain.Play;
import toolc.yourlist.playlist.domain.PlayTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

  @Enumerated(value = EnumType.STRING)
  private Platform platform;

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
    String channelTitle,
    Platform platform) {
    this.title = title;
    this.videoId = videoId;
    this.sequence = sequence;
    this.thumbnail = thumbnail;
    this.playlistId = playlistId;
    this.start = start;
    this.end = end;
    this.channelImage = channelImage;
    this.channelTitle = channelTitle;
    this.platform = platform;
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
      play.channel().title(),
      play.platform());
  }

  void time(PlayTime time) {
    this.start = time.startTime();
    this.end = time.endTime();
  }

  void sequence(Long sequence) {
    this.sequence = sequence;
  }
}