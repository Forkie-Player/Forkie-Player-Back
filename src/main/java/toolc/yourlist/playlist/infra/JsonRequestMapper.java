package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.member.domain.AuthenticationUser;
import toolc.yourlist.playlist.domain.*;

import java.util.stream.Collectors;

@RequiredArgsConstructor
public class JsonRequestMapper {
  private final ValidRequestFactory factory;

  SaveRequest toCreateRequest(AuthenticationUser authenticationUser, JsonSaveRequest jsonRequest) {
    return new SaveRequest(new User(authenticationUser), jsonRequest.title());
  }

  UpdateRequest toUpdateRequest(AuthenticationUser authenticationUser, JsonUpdateRequest jsonRequest) {
    var validRequest = factory.createForPlaylist(
      new User(authenticationUser),
      jsonRequest.playlistId());

    return new UpdateRequest(validRequest, jsonRequest.title());
  }

  DeleteRequest toDeleteRequest(AuthenticationUser authenticationUser, JsonDeleteRequest jsonRequest) {
    var validRequest = factory.createForPlaylist(
      new User(authenticationUser),
      jsonRequest.playlistId());

    return new DeleteRequest(validRequest);
  }

  AddPlayRequest toAddPlayRequest(AuthenticationUser authenticationUser, JsonAddPlayRequest jsonRequest) {
    var validRequest = factory.createForPlaylist(
      new User(authenticationUser),
      jsonRequest.playlistId());
    var time = new PlayTime(jsonRequest.startTime(), jsonRequest.endTime());
    var channel = new Channel(jsonRequest.channelTitle(), jsonRequest.channelImg());
    var info = new PlayInfo(jsonRequest.title(), jsonRequest.videoId(), jsonRequest.thumbnail());

    return new AddPlayRequest(validRequest, info, time, channel);
  }

  ReadAllPlaysRequest toReadAllPlaysRequest(
    AuthenticationUser authenticationUser,
    Long playlistId) {
    var validRequest = factory.createForPlaylist(
      new User(authenticationUser),
      playlistId);

    return new ReadAllPlaysRequest(validRequest);
  }

  TimeUpdateRequest toTimeUpdateRequest(
    AuthenticationUser authenticationUser,
    JsonUpdateTimeRequest jsonRequest) {
    var validRequest = factory.createForPlay(
      new User(authenticationUser),
      jsonRequest.playlistId(),
      jsonRequest.playId());
    var time = new PlayTime(jsonRequest.startTime(), jsonRequest.endTime());

    return new TimeUpdateRequest(validRequest, time);
  }

  public PlaySequencesForUpdate toPlaySequencesForUpdate(
    AuthenticationUser authenticationUser,
    JsonUpdateSequenceRequest jsonRequest) {
    var sequenceList = jsonRequest.list().stream()
      .map(jsonPlaySequence -> {
        var validRequest = factory.createForPlay(
          new User(authenticationUser),
          jsonRequest.playlistId(),
          jsonPlaySequence.playId());

        return new PlaySequence(validRequest, jsonPlaySequence.sequence() - 1);
      })
      .collect(Collectors.toList());

    return new PlaySequencesForUpdate(sequenceList);
  }

  public ValidRequestForPlay toValidRequestForPlay(
    AuthenticationUser authenticationUser,
    JsonExceptPlayRequest jsonRequest) {
    return factory.createForPlay(
      new User(authenticationUser),
      jsonRequest.playlistId(),
      jsonRequest.playId());
  }
}
