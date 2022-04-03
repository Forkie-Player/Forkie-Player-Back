package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import toolc.yourlist.member.domain.Auth;
import toolc.yourlist.member.domain.AuthenticationUser;
import toolc.yourlist.playlist.domain.SequenceUpdater;

import javax.validation.Valid;

import static toolc.yourlist.common.infra.JsonResponse.ok;

@RestController
@RequiredArgsConstructor
public class UpdateSequenceApi {
  private final JsonRequestMapper mapper;
  private final SequenceUpdater updater;

  @PatchMapping("api/play/sequence")
  public ResponseEntity<?> update(
    @Auth AuthenticationUser authenticationUser,
    @Valid @RequestBody JsonUpdateSequenceRequest jsonRequest) {
    updater.update(mapper.toPlaySequencesForUpdate(authenticationUser, jsonRequest));

    return ok("영상 순서 수정 성공");
  }
}
