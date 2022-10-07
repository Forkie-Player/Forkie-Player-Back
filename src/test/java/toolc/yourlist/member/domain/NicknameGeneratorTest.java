package toolc.yourlist.member.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

class NicknameGeneratorTest {

  @Test
  void generate() {
    var adjectiveList = List.of("하품하는", "씩씩한", "물구나무서는");
    var nounList = List.of("물개", "푸들", "이구아나");

    System.out.println(NicknameGenerator.generate(adjectiveList, nounList));
    System.out.println(NicknameGenerator.generate(adjectiveList, nounList));
    System.out.println(NicknameGenerator.generate(adjectiveList, nounList));
  }
}