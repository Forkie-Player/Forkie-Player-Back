package toolc.yourlist.playlist.domain;

import io.vavr.control.Either;

public interface CreateSaveRequest {
  Either<String, SaveRequest> create(Long memberId, String title);
}
