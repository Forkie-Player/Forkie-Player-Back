package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import toolc.yourlist.common.infra.JsonResponse;

import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@RestController
@Controller
public class CreateApi {
  private final PlaylistCreator creator;

  @PostMapping("/api/member-playlist")
  public ResponseEntity<?> createPlaylistForRealMember(@Valid @RequestBody JsonSaveRequest request) {
    creator.createForRealMember(request.memberId(), request.title());
    return JsonResponse.success("생성 성공");
  }

  @PostMapping("/api/non-member-playlist")
  public ResponseEntity<?> createPlaylistForNonMember(@Valid @RequestBody JsonSaveRequest request) {
    creator.createForNonMember(request.memberId(), request.title());
    return JsonResponse.success("생성 성공");
  }
}
