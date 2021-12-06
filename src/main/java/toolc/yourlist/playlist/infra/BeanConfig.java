package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import toolc.yourlist.member.domain.AllMember;
import toolc.yourlist.play.infra.JpaPlayAdapter;
import toolc.yourlist.play.infra.JpaPlayRepository;
import toolc.yourlist.play.infra.Play;
import toolc.yourlist.playlist.domain.AllPlaylists;

@Configuration("PlaylistBeanConfig")
@RequiredArgsConstructor
public class BeanConfig {
  @Bean
  AllPlaylists allPlaylists(JpaPlaylistRepository jpaPlaylistRepository) {
    return new JpaPlaylistAdapter(jpaPlaylistRepository);
  }


  @Bean
  PlaylistCreator playlistCreator(AllMember allMember,
                                  AllPlaylists allPlaylists) {
    return new PlaylistCreator(allMember, allPlaylists);
  }

  @Bean
  PlaylistUpdater playlistUpdater(AllPlaylists allPlaylists, AllMember allMember) {
    return new PlaylistUpdater(allPlaylists, allMember);
  }

  @Bean
  Play play(JpaPlayRepository playRepository) {
    return new JpaPlayAdapter(playRepository);
  }
}
