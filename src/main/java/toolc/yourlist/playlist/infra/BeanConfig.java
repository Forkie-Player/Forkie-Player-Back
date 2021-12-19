package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import toolc.yourlist.member.domain.AllMember;
import toolc.yourlist.play.infra.JpaPlayAdapter;
import toolc.yourlist.play.infra.JpaPlayRepository;
import toolc.yourlist.play.infra.Play;
import toolc.yourlist.playlist.domain.*;

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
  CreateRequestFactory createRequestFactory(AllMember allMember) {
    return new CreateRequestFactory(allMember);
  }

  @Bean
  JsonCreateRequestMapper createRequestMapper(CreateRequestFactory factory) {
    return new JsonCreateRequestMapper(factory);
  }

  @Bean
  PlaylistCreator playlistCreator(AllPlaylists allPlaylists) {
    return new PlaylistCreator(allPlaylists);
  }

  @Bean
  UpdateRequestFactory updateRequestFactory(AllMember allMember, AllPlaylists allPlaylists) {
    return new UpdateRequestFactory(allMember, allPlaylists);
  }

  @Bean
  JsonUpdateRequestMapper updateRequestMapper(UpdateRequestFactory factory) {
    return new JsonUpdateRequestMapper(factory);
  }

  @Bean
  PlaylistUpdater playlistUpdater(AllPlaylists allPlaylists) {
    return new PlaylistUpdater(allPlaylists);
  }

  @Bean
  Play play(JpaPlayRepository playRepository) {
    return new JpaPlayAdapter(playRepository);
  }
}
