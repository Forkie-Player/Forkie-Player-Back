package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.playlist.domain.*;

import java.util.stream.Collectors;

@RequiredArgsConstructor
public class JsonRequestMapper {
  private final EqualMemberFactory factory;

  SaveRequest toCreateRequest(JsonSaveRequest jsonRequest) {
    return new SaveRequest(jsonRequest.memberId(), jsonRequest.title());
  }

  UpdateRequest toUpdateRequest(JsonUpdateRequest jsonRequest) {
    var validRequest = factory.createForPlaylist(jsonRequest.memberId(), jsonRequest.playlistId());

    return new UpdateRequest(validRequest, jsonRequest.title());
  }

  DeleteRequest toDeleteRequest(JsonDeleteRequest jsonRequest) {
    var validRequest = factory.createForPlaylist(jsonRequest.memberId(), jsonRequest.playlistId());

    return new DeleteRequest(validRequest);
  }

  AddPlayRequest toAddPlayRequest(JsonAddPlayRequest jsonRequest) {
    var validRequest = factory.createForPlaylist(jsonRequest.memberId(), jsonRequest.playlistId());
    var time = new PlayTime(jsonRequest.startTime(), jsonRequest.endTime());
    var channel = new Channel(jsonRequest.channelTitle(), jsonRequest.channelImg());
    var info = new PlayInfo(jsonRequest.title(), jsonRequest.videoId(), jsonRequest.thumbnail());

    return new AddPlayRequest(validRequest, info, time, channel);
  }

  ReadAllPlaysRequest toReadAllPlaysRequest(JsonReadAllPlaysRequest jsonRequest) {
    var validRequest = factory.createForPlaylist(jsonRequest.memberId(), jsonRequest.playlistId());

    return new ReadAllPlaysRequest(validRequest);
  }

  TimeUpdateRequest toTimeUpdateRequest(JsonUpdateTimeRequest jsonRequest) {
    var validRequest = factory.createForPlay(
      jsonRequest.memberId(),
      jsonRequest.playlistId(),
      jsonRequest.playId());
    var time = new PlayTime(jsonRequest.startTime(), jsonRequest.endTime());

    return new TimeUpdateRequest(validRequest, time);
  }

  public PlaySequencesForUpdate toPlaySequencesForUpdate(JsonUpdateSequenceRequest jsonRequest) {
    var sequenceList = jsonRequest.list().stream()
      .map(jsonPlaySequence -> {
        var validRequest = factory.createForPlay(
          jsonRequest.memberId(),
          jsonRequest.playlistId(),
          jsonPlaySequence.playId());

        return new PlaySequence(validRequest, jsonPlaySequence.sequence() - 1);
      })
      .collect(Collectors.toList());

    return new PlaySequencesForUpdate(sequenceList);
  }
}
