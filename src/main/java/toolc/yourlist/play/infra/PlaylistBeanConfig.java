package toolc.yourlist.play.infra;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import toolc.yourlist.play.domain.PlayRepository;
import toolc.yourlist.play.domain.PlaylistRepository;

@Configuration
@RequiredArgsConstructor
public class PlaylistBeanConfig {
  private final PlaylistRepository playlistRepository;
  private final PlayRepository playRepository;

  @Bean
  public AllPlaylists allPlaylists() {
    return new AllPlaylists(playlistRepository);
  }

  @Bean
  public ThumbnailOfPlaylist thumbnailOfPlaylist() {
    return new ThumbnailOfPlaylist(playRepository);
  }
}
