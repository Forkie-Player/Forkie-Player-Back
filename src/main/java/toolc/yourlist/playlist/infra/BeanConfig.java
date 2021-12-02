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
  SavePersisting savePersisting(JpaPlaylistRepository playlistRepository) {
    return new JpaSaveAdapter(playlistRepository);
  }

  @Bean
  EqualOwnerCondition equalOwnerCondition(AllMember allMember) {
    return new EqualOwnerCondition(allMember);
  }

  @Bean
  MemberCondition memberCondition(AllMember allMember) {
    return new MemberCondition(allMember);
  }

  @Bean
  PlaylistCountCondition playlistCountCondition(ReadPersisting readPersisting) {
    return new PlaylistCountCondition(readPersisting);
  }

  @Bean
  PlaylistCreator playlistCreator(SavePersisting savePersisting,
                                  MemberCondition memberCondition,
                                  PlaylistCountCondition playlistCountCondition) {
    return new PlaylistCreator(savePersisting, memberCondition, playlistCountCondition);
  }

  @Bean
  Play play(JpaPlayRepository playRepository) {
    return new JpaPlayAdapter(playRepository);
  }
}
