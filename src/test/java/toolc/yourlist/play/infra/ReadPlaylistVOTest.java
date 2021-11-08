package toolc.yourlist.play.infra;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import toolc.yourlist.play.domain.PlaylistVO;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static toolc.yourlist.PlaylistFixture.playlistEntityList;

@ExtendWith(MockitoExtension.class)
class ReadPlaylistVOTest {
  @Mock
  ReadPlaylistEntity readPlaylistEntityList;
  @Mock
  ReadThumbnail readThumbnail;

  @InjectMocks
  ReadPlaylistVO readPlaylistVO;

  @Test
  void 리스트_가져오기() {
    given(readPlaylistEntityList.readList(any())).willReturn(playlistEntityList());
    given(readThumbnail.read(any())).willReturn("thumbnail");

    List<PlaylistVO> playlistVOList = readPlaylistVO.readList(1L);

    assertThat(playlistVOList, is(getPlaylistVOList()));
  }

  private List<PlaylistVO> getPlaylistVOList() {
    return playlistEntityList()
      .stream()
      .map(playlistEntity ->
        PlaylistVO.builder()
          .id(playlistEntity.id())
          .thumbnail("thumbnail")
          .build()).
      collect(Collectors.toList());
  }
}