package toolc.yourlist.play.infra;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import toolc.yourlist.play.domain.PlayRepository;
import toolc.yourlist.play.domain.PlaylistRepository;

@Configuration
@RequiredArgsConstructor
public class PlaylistBeanConfig {
  @Bean
  public AllPlaylists allPlaylists(PlaylistRepository playlistRepository) {
    return new AllPlaylists(playlistRepository);
  }

  @Bean
  public ThumbnailOfPlaylist thumbnailOfPlaylist(PlayRepository playRepository) {
    return new ThumbnailOfPlaylist(playRepository);
  }
}
