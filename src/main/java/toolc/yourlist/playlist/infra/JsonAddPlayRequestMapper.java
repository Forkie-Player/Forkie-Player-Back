package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.playlist.domain.*;

@RequiredArgsConstructor
class JsonAddPlayRequestMapper {
  private final AllMember allMember;
  private final AllPlaylists allPlaylists;

  public AddPlayRequest toAddPlayRequest(JsonAddPlayRequest jsonRequest) {
    var member = allMember.findById(jsonRequest.memberId());
    var playlist = allPlaylists.readBelongsTo(jsonRequest.playlistId());
    var playTime = new PlayTime(jsonRequest.startTime(), jsonRequest.endTime());
    var channel = new Channel(jsonRequest.channelTitle(), jsonRequest.channelImg());
    var play = Play.builder()
      .title(jsonRequest.title())
      .videoId(jsonRequest.videoId())
      .thumbnail(jsonRequest.thumbnail())
      .playTime(playTime)
      .channel(channel)
      .build();

    return new AddPlayRequest(member, playlist, play);
  }
}
