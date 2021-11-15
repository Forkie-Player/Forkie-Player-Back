package toolc.yourlist.play.infra;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import toolc.yourlist.member.domain.MemberRepository;
import toolc.yourlist.play.domain.PlayRepository;
import toolc.yourlist.play.domain.PlaylistRepository;

@Configuration
@RequiredArgsConstructor
public class PlaylistBeanConfig {
  @Bean
  public PlaylistStorage playlistStorage(PlaylistRepository playlistRepository) {
    return new PlaylistStorage(playlistRepository);
  }

  @Bean
  public ThumbnailOfPlaylist thumbnailOfPlaylist(PlayRepository playRepository) {
    return new ThumbnailOfPlaylist(playRepository);
  }

  @Bean
  public PlaylistSaveRequests playlistSaveRequests(MemberRepository memberRepository, PlaylistRepository playlistRepository) {
    return new PlaylistSaveRequests(memberRepository, playlistRepository);
  }
}
