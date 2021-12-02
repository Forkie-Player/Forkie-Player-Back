package toolc.yourlist.playlist.infra;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CountExceedCondition {
  private final ReadPersisting readPersisting;
  boolean check(Long memberId) {
    long count = readPersisting.havingCountOf(memberId);
    return count >= 5;
  }
}
