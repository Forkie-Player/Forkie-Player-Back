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
  CreateReadRequest readRequestFactory(AllMember allMember) {
    return new ReadRequestFactory(allMember);
  }

  @Bean
  MemberIdMapper memberIdMapper(CreateReadRequest factory) {
    return new MemberIdMapper(factory);
  }

  @Bean
  PlaylistReader playlistReader(AllPlaylists allPlaylists) {
    return new PlaylistReader(allPlaylists);
  }

  @Bean
  CreateSaveRequest saveRequestFactory(AllMember allMember) {
    return new SaveRequestFactory(allMember);
  }

  @Bean
  JsonSaveRequestMapper jsonSaveRequestMapper(CreateSaveRequest factory) {
    return new JsonSaveRequestMapper(factory);
  }

  @Bean
  PlaylistCreator playlistCreator(AllPlaylists allPlaylists) {
    return new PlaylistCreator(allPlaylists);
  }

  @Bean
  CreateUpdateRequest updateRequestFactory(AllMember allMember, AllPlaylists allPlaylists) {
    return new UpdateRequestFactory(allMember, allPlaylists);
  }

  @Bean
  JsonUpdateRequestMapper jsonUpdateRequestMapper(CreateUpdateRequest factory) {
    return new JsonUpdateRequestMapper(factory);
  }

  @Bean
  PlaylistUpdater playlistUpdater(AllPlaylists allPlaylists) {
    return new PlaylistUpdater(allPlaylists);
  }

  @Bean
  DeleteRequestFactory deleteRequestFactory(AllMember allMember, AllPlaylists allPlaylists) {
    return new DeleteRequestFactory(allMember, allPlaylists);
  }

  @Bean
  JsonDeleteRequestMapper jsonDeleteRequestMapper(DeleteRequestFactory factory) {
    return new JsonDeleteRequestMapper(factory);
  }

  @Bean
  PlaylistEliminator playlistEliminator(AllPlaylists allPlaylists) {
    return new PlaylistEliminator(allPlaylists);
  }

  @Bean
  Play play(JpaPlayRepository playRepository) {
    return new JpaPlayAdapter(playRepository);
  }
}
