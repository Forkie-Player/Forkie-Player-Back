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
  EqualMemberFactory equalOwnerFactory(AllMember allMember, AllPlaylists allPlaylists, AllPlay allPlay) {
    return new EqualMemberFactory(allMember, allPlaylists, allPlay);
  }

  @Bean
  MemberIdMapper memberIdMapper(AllMember allMember) {
    return new MemberIdMapper(allMember);
  }

  @Bean
  JsonRequestMapper jsonRequestMapper(EqualMemberFactory factory) {
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
  ChangeThumbnail playlistThumbnail(AllPlaylists allPlaylists) {
    return new PlaylistThumbnail(allPlaylists);
  }

  @Bean
  PlayAdder playAdder(AllPlay allPlay, ChangeThumbnail changeThumbnail) {
    return new PlayAdder(allPlay, changeThumbnail);
  }

  @Bean
  PlayReader playReader(AllPlay allPlay) {
    return new PlayReader(allPlay);
  }

  @Bean
  TimeUpdater timeUpdater(AllPlay allPlay) {
    return new TimeUpdater(allPlay);
  }

  @Bean
  SequenceUpdater sequenceUpdater(AllPlay allPlay, ChangeThumbnail changeThumbnail) {
    return new SequenceUpdater(allPlay, changeThumbnail);
  }
}
