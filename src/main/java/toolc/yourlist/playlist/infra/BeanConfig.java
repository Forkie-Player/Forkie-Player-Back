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
  MemberExistCondition preCondition(AllMember allMember) {
    return new MemberExistCondition(allMember);
  }

  @Bean
  EqualOwnerCondition updateTitleCondition(AllMember allMember) {
    return new EqualOwnerCondition(allMember);
  }

  @Bean
  public PersistingPlaylist playlist(JpaPlaylistRepository playlistRepository, AllMember allMember) {
    return new JpaPlaylistAdapter(playlistRepository, allMember);
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
  PlaylistMapper mapper(ThumbnailOfPlaylist thumbnailOfPlaylist) {
    return new PlaylistMapper(thumbnailOfPlaylist);
  }

  @Bean
  JsonSaveRequestMapper requestMapper(PersistingPlaylist persistingPlaylist, MemberExistCondition memberExistCondition) {
    return new JsonSaveRequestMapper(persistingPlaylist, memberExistCondition);
  }
}
