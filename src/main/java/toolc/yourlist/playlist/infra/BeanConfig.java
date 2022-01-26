package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import toolc.yourlist.member.domain.MakeDefaultPlayList;
import toolc.yourlist.member.infra.JpaAllMemberEntity;
import toolc.yourlist.play.infra.JpaPlayAdapter;
import toolc.yourlist.play.infra.JpaPlayRepository;
import toolc.yourlist.play.infra.Play;
import toolc.yourlist.playlist.domain.*;
import toolc.yourlist.playlist.usecase.DefaultPlaylist;

@Configuration("PlaylistBeanConfig")
@RequiredArgsConstructor
class BeanConfig {
  @Bean
  AllMember allMemberInPlaylist(JpaAllMemberEntity jpaAllMemberEntity) {
    return new AllMemberMapper(jpaAllMemberEntity);
  }

  @Bean
  AllPlaylists allPlaylists(JpaPlaylistRepository jpaPlaylistRepository) {
    return new JpaPlaylistAdapter(jpaPlaylistRepository);
  }

  @Bean
  ReadRequestFactory readRequestFactory(AllMember allMember) {
    return new ReadRequestFactory(allMember);
  }

  @Bean
  MemberIdMapper memberIdMapper(ReadRequestFactory factory) {
    return new MemberIdMapper(factory);
  }

  @Bean
  PlaylistReader playlistReader(AllPlaylists allPlaylists) {
    return new PlaylistReader(allPlaylists);
  }

  @Bean
  SaveRequestFactory saveRequestFactory(AllMember allMember) {
    return new SaveRequestFactory(allMember);
  }

  @Bean
  JsonSaveRequestMapper jsonSaveRequestMapper(SaveRequestFactory factory) {
    return new JsonSaveRequestMapper(factory);
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
  JsonUpdateRequestMapper jsonUpdateRequestMapper(UpdateRequestFactory factory) {
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

  @Bean
  MakeDefaultPlayList defaultPlaylist(AllPlaylists allPlaylists){
    return new DefaultPlaylist(allPlaylists);
  }
}
