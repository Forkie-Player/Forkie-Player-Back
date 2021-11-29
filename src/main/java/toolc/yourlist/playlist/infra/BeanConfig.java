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
  SavePolicy saveRequestPolicy() {
    return new CountLimitOrRealMember();
  }

  @Bean
  ReadPersisting readPersisting(JpaPlaylistRepository playlistRepository, AllMember allMember) {
    return new JpaReadAdapter(playlistRepository, allMember);
  }

  @Bean
  UpdatePersisting updatePersisting(JpaPlaylistRepository playlistRepository, AllMember allMember) {
    return new JpaUpdateAdapter(playlistRepository, allMember);
  }

  @Bean
  SavePersisting savePersisting(JpaPlaylistRepository playlistRepository,
                                AllMember allMember,
                                SavePolicy savePolicy) {
    return new JpaSaveAdapter(playlistRepository, allMember, savePolicy);
  }

  @Bean
  PlaylistExistCondition playlistExistCondition(ReadPersisting readPersisting) {
    return new PlaylistExistCondition(readPersisting);
  }

  @Bean
  MemberExistCondition memberExistCondition(AllMember allMember) {
    return new MemberExistCondition(allMember);
  }

  @Bean
  EqualOwnerCondition equalOwnerCondition(AllMember allMember) {
    return new EqualOwnerCondition(allMember);
  }

  @Bean
  Play play(JpaPlayRepository playRepository) {
    return new JpaPlayAdapter(playRepository);
  }

  @Bean
  ReadThumbnail readThumbnail(Play play) {
    return new ThumbnailOfPlaylist(play);
  }

  @Bean
  JsonSaveRequestMapper requestMapper(ReadPersisting readPersisting,
                                      MemberExistCondition memberExistCondition,
                                      SavePolicy savePolicy) {
    return new JsonSaveRequestMapper(
      readPersisting,
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
