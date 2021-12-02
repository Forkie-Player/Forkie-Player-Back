package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import toolc.yourlist.member.domain.AllMember;
import toolc.yourlist.play.infra.JpaPlayAdapter;
import toolc.yourlist.play.infra.JpaPlayRepository;
import toolc.yourlist.play.infra.Play;

@Configuration("PlaylistBeanConfig")
@RequiredArgsConstructor
public class BeanConfig {
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
  CountPolicyForNonMember savePolicyForNonMember(ReadPersisting readPersisting) {
    return new CountPolicyForNonMember(readPersisting);
  }

  @Bean
  PlaylistCreator playlistCreator(AllMember allMember,
                                  SavePersisting savePersisting,
                                  CountPolicyForNonMember countPolicyForNonMember) {
    return new PlaylistCreator(allMember, savePersisting, countPolicyForNonMember);
  }

  @Bean
  OwnerPolicy ownerPolicy(AllMember allMember, ReadPersisting readPersisting) {
    return new OwnerPolicy(allMember, readPersisting);
  }

  @Bean
  PlaylistUpdater playlistUpdater(UpdatePersisting updatePersisting, OwnerPolicy ownerPolicy) {
    return new PlaylistUpdater(updatePersisting, ownerPolicy);
  }

  @Bean
  Play play(JpaPlayRepository playRepository) {
    return new JpaPlayAdapter(playRepository);
  }
}
