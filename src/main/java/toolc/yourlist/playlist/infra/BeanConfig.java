package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import toolc.yourlist.auth.domain.MakeDefaultPlayList;
import toolc.yourlist.member.infra.JpaAllMemberEntity;
import toolc.yourlist.playlist.domain.*;
import toolc.yourlist.playlist.usecase.DefaultPlaylist;

@Configuration("PlaylistBeanConfig")
@RequiredArgsConstructor
class BeanConfig {
  @Bean
  AllMember allMemberInPlaylist(JpaAllMemberEntity jpaAllMemberEntity) {
    return new JpaMemberAdapter(jpaAllMemberEntity);
  }

  @Bean
  AllPlaylists allPlaylists(JpaPlaylistRepository jpaPlaylistRepository) {
    return new JpaPlaylistAdapter(jpaPlaylistRepository);
  }

  @Bean
  AllPlay allPlay(JpaPlayRepository jpaPlayRepository) {
    return new JpaPlayAdapter(jpaPlayRepository);
  }

  @Bean
  MemberIdMapper memberIdMapper(AllMember allMember) {
    return new MemberIdMapper(allMember);
  }

  @Bean
  PlaylistReader playlistReader(AllPlaylists allPlaylists) {
    return new PlaylistReader(allPlaylists);
  }

  @Bean
  JsonSaveRequestMapper jsonSaveRequestMapper(AllMember allMember) {
    return new JsonSaveRequestMapper(allMember);
  }

  @Bean
  PlaylistCreator playlistCreator(AllPlaylists allPlaylists) {
    return new PlaylistCreator(allPlaylists);
  }

  @Bean
  JsonUpdateRequestMapper jsonUpdateRequestMapper(AllMember allMember, AllPlaylists allPlaylists) {
    return new JsonUpdateRequestMapper(allMember, allPlaylists);
  }

  @Bean
  PlaylistUpdater playlistUpdater(AllPlaylists allPlaylists) {
    return new PlaylistUpdater(allPlaylists);
  }

  @Bean
  JsonDeleteRequestMapper jsonDeleteRequestMapper(AllMember allMember, AllPlaylists allPlaylists) {
    return new JsonDeleteRequestMapper(allMember, allPlaylists);
  }

  @Bean
  PlaylistEliminator playlistEliminator(AllPlaylists allPlaylists) {
    return new PlaylistEliminator(allPlaylists);
  }

  @Bean
  MakeDefaultPlayList defaultPlaylist(AllPlaylists allPlaylists) {
    return new DefaultPlaylist(allPlaylists);
  }

  @Bean
  JsonAddPlayRequestMapper jsonAddPlayRequestMapper(AllMember allMember, AllPlaylists allPlaylists) {
    return new JsonAddPlayRequestMapper(allMember, allPlaylists);
  }

  @Bean
  PlayAdder playAdder(AllPlay allPlay, AllPlaylists allPlaylists) {
    return new PlayAdder(allPlay, allPlaylists);
  }
}
