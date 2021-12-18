package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import toolc.yourlist.member.domain.AllMember;
import toolc.yourlist.play.infra.JpaPlayAdapter;
import toolc.yourlist.play.infra.JpaPlayRepository;
import toolc.yourlist.play.infra.Play;
import toolc.yourlist.playlist.domain.AllPlaylists;
import toolc.yourlist.playlist.domain.PlaylistCreator;
import toolc.yourlist.playlist.domain.PlaylistReader;
import toolc.yourlist.playlist.domain.PlaylistUpdater;

@Configuration("PlaylistBeanConfig")
@RequiredArgsConstructor
class BeanConfig {
  @Bean
  AllPlaylists allPlaylists(JpaPlaylistRepository jpaPlaylistRepository) {
    return new JpaPlaylistAdapter(jpaPlaylistRepository);
  }

  @Bean
  PlaylistReader playlistReader(AllMember allMember, AllPlaylists allPlaylists) {
    return new PlaylistReader(allMember, allPlaylists);
  }

  @Bean
  PlaylistCreator playlistCreator(AllMember allMember,
                                  AllPlaylists allPlaylists) {
    return new PlaylistCreator(allMember, allPlaylists);
  }

  @Bean
  PlaylistUpdater playlistUpdater(AllMember allMember, AllPlaylists allPlaylists) {
    return new PlaylistUpdater(allMember, allPlaylists);
  }

  @Bean
  Play play(JpaPlayRepository playRepository) {
    return new JpaPlayAdapter(playRepository);
  }
}
