package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import toolc.yourlist.member.domain.Auth;
import toolc.yourlist.member.domain.AuthenticationUser;
import toolc.yourlist.playlist.domain.PlayAdder;

import static toolc.yourlist.common.infra.JsonResponse.ok;

@RestController
@RequiredArgsConstructor
class AddPlayApi {
  private final JsonRequestMapper mapper;
  private final PlayAdder adder;

  @PostMapping("/api/play")
  public ResponseEntity<?> addPlay(
    @Auth AuthenticationUser authenticationUser,
    @RequestBody JsonAddPlayRequest jsonRequest) {
    adder.add(mapper.toAddPlayRequest(authenticationUser, jsonRequest));

    return ok("영상 추가 성공");
  }
}
