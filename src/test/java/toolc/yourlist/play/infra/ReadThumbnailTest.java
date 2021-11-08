package toolc.yourlist.play.infra;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import toolc.yourlist.play.domain.PlayRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class ReadThumbnailTest {
  @Mock
  PlayRepository playRepository;

  @InjectMocks
  ReadThumbnail readThumbnail;

  @Test
  void 플레이리스트의_썸네일_찾기() {
    PlayEntity playEntity1 = new PlayEntity();
    PlayEntity playEntity2 = new PlayEntity();
    PlayEntity playEntity3 = new PlayEntity();
    List<PlayEntity> playEntityList = Arrays.asList(playEntity1, playEntity2, playEntity3);
    given(playRepository.findByPlaylistId(any())).willReturn(playEntityList);

    String thumbnail = readThumbnail.read(1L);

    assertThat("thumbnail", is(thumbnail));
  }
}