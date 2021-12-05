package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import toolc.yourlist.member.domain.AllMember;
import toolc.yourlist.play.infra.JpaPlayAdapter;
import toolc.yourlist.play.infra.JpaPlayRepository;
import toolc.yourlist.play.infra.Play;
import toolc.yourlist.playlist.domain.ReadPlaylist;
import toolc.yourlist.playlist.domain.SavePlaylist;
import toolc.yourlist.playlist.domain.UpdatePlaylist;

@Configuration("PlaylistBeanConfig")
@RequiredArgsConstructor
public class BeanConfig {
  @Bean
  ReadPlaylist readPlaylist(JpaPlaylistRepository playlistRepository, AllMember allMember) {
    return new JpaReadAdapter(playlistRepository, allMember);
  }

  @Bean
  UpdatePlaylist updatePlaylist(JpaPlaylistRepository playlistRepository) {
    return new JpaUpdateAdapter(playlistRepository);
  }

  @Bean
  SavePlaylist savePlaylist(JpaPlaylistRepository playlistRepository) {
    return new JpaSaveAdapter(playlistRepository);
  }

  @Bean
  CountPolicyForNonMember savePolicyForNonMember(ReadPlaylist readPlaylist) {
    return new CountPolicyForNonMember(readPlaylist);
  }

  @Bean
  PlaylistCreator playlistCreator(AllMember allMember,
                                  SavePlaylist savePlaylist,
                                  CountPolicyForNonMember countPolicyForNonMember) {
    return new PlaylistCreator(allMember, savePlaylist, countPolicyForNonMember);
  }

  @Bean
  OwnerPolicy ownerPolicy(AllMember allMember, ReadPlaylist readPlaylist) {
    return new OwnerPolicy(allMember, readPlaylist);
  }

  @Bean
  PlaylistUpdater playlistUpdater(UpdatePlaylist updatePlaylist, OwnerPolicy ownerPolicy) {
    return new PlaylistUpdater(updatePlaylist, ownerPolicy);
  }

  @Bean
  Play play(JpaPlayRepository playRepository) {
    return new JpaPlayAdapter(playRepository);
  }
}
