package toolc.yourlist.play.domain;

public class PlaylistSaveRequestFixture {
  public static PlaylistSaveRequest.PlaylistSaveRequestBuilder playlistSaveRequest() {
    return PlaylistSaveRequest.builder()
      .memberId(1L)
      .title("title");
  }
}
