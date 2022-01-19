package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.playlist.domain.*;

@RequiredArgsConstructor
class JsonAddPlayRequestMapper {
  private final EqualOwnerFactory equalOwnerFactory;

  public AddPlayRequest toAddPlayRequest(JsonAddPlayRequest jsonRequest) {
    var equalOwner = equalOwnerFactory.create(jsonRequest.memberId(), jsonRequest.playlistId());
    var time = new PlayTime(jsonRequest.startTime(), jsonRequest.endTime());
    var channel = new Channel(jsonRequest.channelTitle(), jsonRequest.channelImg());
    var info = new PlayInfo(jsonRequest.title(), jsonRequest.videoId(), jsonRequest.thumbnail());

    return new AddPlayRequest(equalOwner, info, time, channel);
  }
}
