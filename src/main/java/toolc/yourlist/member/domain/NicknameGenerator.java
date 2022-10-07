package toolc.yourlist.member.domain;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
public class NicknameGenerator {
  private final AllMember allMember;

  String generate(List<String> adjectiveList, List<String> nounList) {
    final Random random = new Random();

    var nickname = adjectiveList.get(random.nextInt(adjectiveList.size())) + ' '
      + nounList.get(random.nextInt(nounList.size()));

    long duplicateCount = allMember.countContainNickname(nickname);

    if (duplicateCount != 0L) {
      return nickname + allMember.countContainNickname(nickname);
    }

    return nickname;
  }
}
