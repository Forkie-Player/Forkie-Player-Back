package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import toolc.yourlist.member.domain.AllMember;
import toolc.yourlist.play.infra.JpaPlayAdapter;
import toolc.yourlist.play.infra.JpaPlayRepository;
import toolc.yourlist.play.infra.Play;
import toolc.yourlist.playlist.domain.CountLimitOrRealMember;
import toolc.yourlist.playlist.domain.SavePolicy;

@Configuration("PlaylistBeanConfig")
@RequiredArgsConstructor
public class BeanConfig {
  @Bean
  public Playlist playlist(JpaPlaylistRepository playlistRepository) {
    return new JpaPlaylistAdapter(playlistRepository);
  }

  @Bean
  Play play(JpaPlayRepository playRepository) {
    return new JpaPlayAdapter(playRepository);
  }

  @Bean
  public ThumbnailOfPlaylist thumbnailOfPlaylist(Play play) {
    return new ThumbnailOfPlaylist(play);
  }

  @Bean
  SavePolicy saveRequestPolicy() {
    return new CountLimitOrRealMember();
  }

  @Bean
  JsonMapper mapper(ThumbnailOfPlaylist thumbnailOfPlaylist) {
    return new JsonMapper(thumbnailOfPlaylist);
  }

  @Bean
  RequestMapper requestMapper(AllMember allMember, Playlist playlist) {
    return new RequestMapper(allMember, playlist);
  }
}
