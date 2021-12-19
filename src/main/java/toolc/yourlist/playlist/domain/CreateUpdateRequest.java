package toolc.yourlist.playlist.domain;

import io.vavr.control.Either;

public interface CreateUpdateRequest {
  Either<String, UpdateRequest> create(Long memberId, Long playlistId, String newTitle);
}
