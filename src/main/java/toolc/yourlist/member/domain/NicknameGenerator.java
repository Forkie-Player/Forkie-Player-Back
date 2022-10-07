package toolc.yourlist.member.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Random;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class NicknameGenerator {
  static String generate(List<String> adjectiveList, List<String> nounList) {
    final Random random = new Random();

    return adjectiveList.get(random.nextInt(adjectiveList.size()))
      + nounList.get(random.nextInt(nounList.size()));
  }
}
