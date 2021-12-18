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
import toolc.yourlist.playlist.domain.ReadPlaylist;
import toolc.yourlist.playlist.domain.UpdatePlaylist;

@Configuration("PlaylistBeanConfig")
@RequiredArgsConstructor
class BeanConfig {
  @Bean
  AllPlaylists allPlaylists(JpaPlaylistRepository jpaPlaylistRepository) {
    return new JpaPlaylistAdapter(jpaPlaylistRepository);
  }

  @Bean
  ReadPlaylist readPlaylist(AllMember allMember, AllPlaylists allPlaylists) {
    return new PlaylistReader(allMember, allPlaylists);
  }

  @Bean
  PlaylistCreator createPlaylist(AllMember allMember,
                                 AllPlaylists allPlaylists) {
    return new PlaylistCreator(allMember, allPlaylists);
  }

  @Bean
  UpdatePlaylist updatePlaylist(AllPlaylists allPlaylists, AllMember allMember) {
    return new PlaylistUpdater(allPlaylists, allMember);
  }

  @Bean
  Play play(JpaPlayRepository playRepository) {
    return new JpaPlayAdapter(playRepository);
  }
}
