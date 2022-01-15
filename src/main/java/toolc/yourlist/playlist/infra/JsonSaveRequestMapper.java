package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.playlist.domain.AllMember;
import toolc.yourlist.playlist.domain.SaveRequest;

@RequiredArgsConstructor
public class JsonSaveRequestMapper {
  private final AllMember allMember;

  SaveRequest toCreateRequest(JsonSaveRequest jsonRequest) {
    var member = allMember.findById(jsonRequest.memberId());

    return new SaveRequest(member, jsonRequest.title());
  }
}
