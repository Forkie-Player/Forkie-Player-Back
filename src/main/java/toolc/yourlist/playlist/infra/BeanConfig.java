package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import toolc.yourlist.member.domain.AllMember;
import toolc.yourlist.play.infra.*;
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
  LoginIdMapper loginIdMapper(AllMember allMember) {
    return new LoginIdMapper(allMember);
  }

  @Bean
  PlaylistReader playlistReader(ReadPersisting readPersisting) {
    return new PlaylistReader(readPersisting);
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
  JsonSaveRequestMapper requestMapper(ReadPersisting readPersisting,
                                      AllMember allMember,
                                      SavePolicy savePolicy) {
    return new JsonSaveRequestMapper(
      readPersisting,
      allMember,
      savePolicy);
  }

  @Bean
  JsonUpdateRequestMapper jsonUpdateRequestMapper(AllMember allMember,
                                                  EqualOwnerCondition equalOwnerCondition,
                                                  ReadPersisting readPersisting) {
    return new JsonUpdateRequestMapper(
      allMember,
      equalOwnerCondition,
      readPersisting);
  }
}
