package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import toolc.yourlist.common.infra.JsonResponse;
import toolc.yourlist.member.domain.Auth;
import toolc.yourlist.member.domain.AuthenticationUser;
import toolc.yourlist.playlist.domain.PlaylistCreator;

import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@RestController
class CreateApi {
  private final PlaylistCreator creator;
  private final JsonRequestMapper requestMapper;

  @PostMapping("/api/playlist")
  public ResponseEntity<?> create(
    @Auth AuthenticationUser authenticationUser,
    @Valid @RequestBody JsonSaveRequest jsonRequest) {
    var result = creator.create(requestMapper.toCreateRequest(authenticationUser, jsonRequest));
    return JsonResponse.okWithData(new PlaylistJson(result), "영상목록 생성 성공");
  }
}