package toolc.yourlist.play.infra;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import toolc.yourlist.play.domain.PlayRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static toolc.yourlist.PlayFixture.playEntity;
import static toolc.yourlist.PlayFixture.playEntityList;

@ExtendWith(MockitoExtension.class)
class ReadThumbnailTest {
  @Mock
  PlayRepository playRepository;

  @InjectMocks
  ReadThumbnail readThumbnail;

  @Test
  void 썸네일_찾기() {
    given(playRepository.findByPlaylistId(any())).willReturn(playEntityList());

    String thumbnail = readThumbnail.read(1L);

    assertThat("thumbnail", is(thumbnail));
  }

  @Test
  void 영상이_없음() {
    given(playRepository.findByPlaylistId(any())).willReturn(Collections.emptyList());

    String thumbnail = readThumbnail.read(1L);

    assertThat(null, is(thumbnail));
  }

  @Test
  void 첫번째_순서_중복() {
    given(playRepository.findByPlaylistId(any())).willReturn(getDuplicateList());

    assertThrows(IllegalArgumentException.class, () -> readThumbnail.read(1L));
  }

  private List<PlayEntity> getDuplicateList() {
    List<PlayEntity> playEntityList = new ArrayList<>();
    playEntityList.add(playEntity().build());
    playEntityList.add(playEntity().build());

    return playEntityList;
  }
}