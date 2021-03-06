package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import toolc.yourlist.member.domain.Auth;
import toolc.yourlist.member.domain.AuthenticationUser;
import toolc.yourlist.playlist.domain.PlaylistUpdater;

import javax.validation.Valid;

import static toolc.yourlist.common.infra.JsonResponse.ok;

@Slf4j
@RequiredArgsConstructor
@RestController
class UpdateApi {
  private final PlaylistUpdater updater;
  private final JsonRequestMapper mapper;

  @PatchMapping("/api/playlist")
  public ResponseEntity<?> updateTitle(
    @Auth AuthenticationUser authenticationUser,
    @Valid @RequestBody JsonUpdateRequest jsonRequest) {
    updater.updateTitle(mapper.toUpdateRequest(authenticationUser, jsonRequest));

    return ok("영상목록 제목 수정 성공");
  }
}