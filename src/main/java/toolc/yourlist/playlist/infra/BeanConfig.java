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
  UpdatePersisting updatePersisting(JpaPlaylistRepository playlistRepository) {
    return new JpaUpdateAdapter(playlistRepository);
  }

  @Bean
  SavePersisting savePersisting(JpaPlaylistRepository playlistRepository) {
    return new JpaSaveAdapter(playlistRepository);
  }

  @Bean
  DifferOwnerCondition equalOwnerCondition(AllMember allMember, ReadPersisting readPersisting) {
    return new DifferOwnerCondition(allMember, readPersisting);
  }

  @Bean
  MemberCondition memberCondition(AllMember allMember) {
    return new MemberCondition(allMember);
  }

  @Bean
  CountExceedCondition playlistCountCondition(ReadPersisting readPersisting) {
    return new CountExceedCondition(readPersisting);
  }

  @Bean
  PlaylistCreator playlistCreator(SavePersisting savePersisting,
                                  MemberCondition memberCondition,
                                  CountExceedCondition countExceedCondition) {
    return new PlaylistCreator(savePersisting, memberCondition, countExceedCondition);
  }

  @Bean
  PlaylistUpdater playlistUpdater(DifferOwnerCondition differOwnerCondition, UpdatePersisting updatePersisting) {
    return new PlaylistUpdater(differOwnerCondition, updatePersisting);
  }

  @Bean
  Play play(JpaPlayRepository playRepository) {
    return new JpaPlayAdapter(playRepository);
  }
}
