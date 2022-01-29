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
  EqualOwnerFactory equalOwnerFactory(AllMember allMember, AllPlaylists allPlaylists) {
    return new EqualOwnerFactory(allMember, allPlaylists);
  }

  @Bean
  MemberIdMapper memberIdMapper(AllMember allMember) {
    return new MemberIdMapper(allMember);
  }

  @Bean
  JsonRequestMapper jsonRequestMapper(EqualOwnerFactory factory) {
    return new JsonRequestMapper(factory);
  }

  @Bean
  PlaylistReader playlistReader(AllPlaylists allPlaylists) {
    return new PlaylistReader(allPlaylists);
  }

  @Bean
  PlaylistCreator playlistCreator(AllMember allMember, AllPlaylists allPlaylists) {
    return new PlaylistCreator(allMember, allPlaylists);
  }

  @Bean
  PlaylistUpdater playlistUpdater(AllPlaylists allPlaylists) {
    return new PlaylistUpdater(allPlaylists);
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
  PlaylistThumbnail playlistThumbnail(AllPlaylists allPlaylists) {
    return new ThumbnailChanger(allPlaylists);
  }

  @Bean
  PlayAdder playAdder(AllPlay allPlay, PlaylistThumbnail playlistThumbnail) {
    return new PlayAdder(allPlay, playlistThumbnail);
  }

  @Bean
  PlayReader playReader(AllPlay allPlay) {
    return new PlayReader(allPlay);
  }
}
