package toolc.yourlist.play.infra;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import toolc.yourlist.member.domain.AllMember;
import toolc.yourlist.play.domain.CountLimitOrRealMember;
import toolc.yourlist.play.domain.SavePolicy;

@Configuration
@RequiredArgsConstructor
public class PlaylistBeanConfig {
  @Bean
  public Playlist playlist(JpaPlaylistRepository playlistRepository) {
    return new JpaPlaylistAdapter(playlistRepository);
  }

  @Bean Play play(JpaPlayRepository playRepository) {
    return new JpaPlayAdapter(playRepository);
  }

  @Bean
  public ThumbnailOfPlaylist thumbnailOfPlaylist(Play play) {
    return new ThumbnailOfPlaylist(play);
  }

  @Bean
  SavePolicy saveRequestPolicy() {
    return new CountLimitOrRealMember();
  }

  @Bean
  PlaylistRequestMapper mapper(AllMember allMember, Playlist playlist) {
    return new PlaylistRequestMapper(allMember, playlist);
  }
}
