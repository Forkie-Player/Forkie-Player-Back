package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import toolc.yourlist.member.domain.MakeDefaultPlayList;
import toolc.yourlist.member.domain.PlaylistOwnerChange;
import toolc.yourlist.playlist.domain.*;
import toolc.yourlist.playlist.usecase.DefaultPlaylist;
import toolc.yourlist.playlist.usecase.OwnerChanger;

@Configuration("PlaylistBeanConfig")
@RequiredArgsConstructor
class BeanConfig {
  @Bean
  AllPlaylists allPlaylists(JpaPlaylistRepository jpaPlaylistRepository) {
    return new JpaPlaylistAdapter(jpaPlaylistRepository);
  }

  @Bean
  AllPlay allPlay(JpaPlayRepository jpaPlayRepository) {
    return new JpaPlayAdapter(jpaPlayRepository);
  }

  @Bean
  ValidRequestFactory validRequestFactory(AllPlaylists allPlaylists, AllPlay allPlay) {
    return new ValidRequestFactory(allPlaylists, allPlay);
  }

  @Bean
  JsonRequestMapper jsonRequestMapper(ValidRequestFactory factory) {
    return new JsonRequestMapper(factory);
  }

  @Bean
  PlaylistReader playlistReader(AllPlaylists allPlaylists) {
    return new PlaylistReader(allPlaylists);
  }

  @Bean
  PlaylistCreator playlistCreator(AllPlaylists allPlaylists) {
    return new PlaylistCreator(allPlaylists);
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
  ChangeThumbnail playlistThumbnail(AllPlaylists allPlaylists, AllPlay allPlay) {
    return new PlaylistThumbnail(allPlaylists, allPlay);
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

  @Bean
  PlayEliminator playEliminator(AllPlay allPlay, SequenceUpdater sequenceUpdater, ChangeThumbnail changeThumbnail) {
    return new PlayEliminator(allPlay, sequenceUpdater, changeThumbnail);
  }

  @Bean
  PlaylistOwnerChange playlistOwnerChange(AllPlaylists allPlaylists) {
    return new OwnerChanger(allPlaylists);
  }
}
