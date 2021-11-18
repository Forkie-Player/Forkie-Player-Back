package toolc.yourlist.play.infra;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import toolc.yourlist.play.domain.CountLimitOrRealMember;
import toolc.yourlist.play.domain.PlayRepository;
import toolc.yourlist.play.domain.PlaylistRepository;
import toolc.yourlist.play.domain.SavePolicy;

@Configuration
@RequiredArgsConstructor
public class PlaylistBeanConfig {
  @Bean
  public PlaylistStorage playlistStorage(PlaylistRepository playlistRepository) {
    return new PlaylistStorage(playlistRepository);
  }

  @Bean
  public ThumbnailOfPlaylist thumbnailOfPlaylist(PlayRepository playRepository) {
    return new ThumbnailOfPlaylist(playRepository);
  }

  @Bean
  SavePolicy saveRequestPolicy() {
    return new CountLimitOrRealMember();
  }
}
