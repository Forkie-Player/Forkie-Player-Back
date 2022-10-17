package toolc.yourlist.member.domain;

import java.util.List;
import java.util.Random;

public class NicknameGenerator {
  private final AllMember allMember;
  private final List<String> nounList;
  private final List<String> adjectiveList;

  public NicknameGenerator(AllMember allMember, WordProvidable wordProvidable) {
    this.allMember = allMember;
    this.nounList = wordProvidable.getNounList();
    this.adjectiveList = wordProvidable.getAdjectiveList();
  }

  String generate() {
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
