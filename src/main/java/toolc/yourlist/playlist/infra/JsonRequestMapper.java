package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.playlist.domain.*;

@RequiredArgsConstructor
public class JsonRequestMapper {
  private final EqualOwnerFactory factory;

  SaveRequest toCreateRequest(JsonSaveRequest jsonRequest) {
    return new SaveRequest(jsonRequest.memberId(), jsonRequest.title());
  }

  UpdateRequest toUpdateRequest(JsonUpdateRequest jsonRequest) {
    var equalOwner = factory.create(jsonRequest.memberId(), jsonRequest.playlistId());

    return new UpdateRequest(equalOwner, jsonRequest.title());
  }

  DeleteRequest toDeleteRequest(JsonDeleteRequest jsonRequest) {
    var equalOwner = factory.create(jsonRequest.memberId(), jsonRequest.playlistId());

    return new DeleteRequest(equalOwner);
  }

  AddPlayRequest toAddPlayRequest(JsonAddPlayRequest jsonRequest) {
    var equalOwner = factory.create(jsonRequest.memberId(), jsonRequest.playlistId());
    var time = new PlayTime(jsonRequest.startTime(), jsonRequest.endTime());
    var channel = new Channel(jsonRequest.channelTitle(), jsonRequest.channelImg());
    var info = new PlayInfo(jsonRequest.title(), jsonRequest.videoId(), jsonRequest.thumbnail());

    return new AddPlayRequest(equalOwner, info, time, channel);
  }
}