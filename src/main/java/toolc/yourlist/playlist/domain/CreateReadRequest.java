package toolc.yourlist.playlist.domain;

import io.vavr.control.Either;

public interface CreateReadRequest {
  Either<String, ReadRequest> create(Long memberId);
}
