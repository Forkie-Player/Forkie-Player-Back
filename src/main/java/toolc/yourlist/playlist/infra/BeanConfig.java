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
  MemberExistCondition memberExistCondition(AllMember allMember) {
    return new MemberExistCondition(allMember);
  }

  @Bean
  EqualOwnerCondition equalOwnerCondition(AllMember allMember) {
    return new EqualOwnerCondition(allMember);
  }

  @Bean
  PlaylistExistCondition playlistExistCondition(PersistingPlaylist persistingPlaylist) {
    return new PlaylistExistCondition(persistingPlaylist);
  }

  @Bean
  SavePolicy saveRequestPolicy() {
    return new CountLimitOrRealMember();
  }

  @Bean
  PersistingPlaylist playlist(JpaPlaylistRepository playlistRepository,
                              AllMember allMember,
                              SavePolicy savePolicy) {
    return new JpaPlaylistAdapter(
      playlistRepository,
      allMember,
      savePolicy);
  }

  @Bean
  Play play(JpaPlayRepository playRepository) {
    return new JpaPlayAdapter(playRepository);
  }

  @Bean
  ThumbnailOfPlaylist thumbnailOfPlaylist(Play play) {
    return new ThumbnailOfPlaylist(play);
  }


  @Bean
  PlaylistMapper mapper(ThumbnailOfPlaylist thumbnailOfPlaylist) {
    return new PlaylistMapper(thumbnailOfPlaylist);
  }

  @Bean
  JsonSaveRequestMapper requestMapper(PersistingPlaylist persistingPlaylist,
                                      MemberExistCondition memberExistCondition,
                                      SavePolicy savePolicy) {
    return new JsonSaveRequestMapper(
      persistingPlaylist,
      memberExistCondition,
      savePolicy);
  }

  @Bean
  JsonUpdateRequestMapper jsonUpdateRequestMapper(MemberExistCondition memberExistCondition,
                                                  EqualOwnerCondition equalOwnerCondition,
                                                  PlaylistExistCondition playlistExistCondition) {
    return new JsonUpdateRequestMapper(
      memberExistCondition,
      equalOwnerCondition,
      playlistExistCondition);
  }
}
