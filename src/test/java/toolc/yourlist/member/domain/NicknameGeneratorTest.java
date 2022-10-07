package toolc.yourlist.member.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class NicknameGeneratorTest {

  @Test
  void generate(@Mock AllMember allMember) {
    var nicknameGenerator = new NicknameGenerator(allMember);
    var adjectiveList = List.of("하품하는", "씩씩한", "물구나무서는");
    var nounList = List.of("물개", "푸들", "이구아나");
    when(allMember.countContainNickname(anyString())).thenReturn(0L);

    System.out.println(nicknameGenerator.generate(adjectiveList, nounList));
    System.out.println(nicknameGenerator.generate(adjectiveList, nounList));
    System.out.println(nicknameGenerator.generate(adjectiveList, nounList));
  }

  @Test
  void generate_duplicate_nickname(@Mock AllMember allMember) {
    var nicknameGenerator = new NicknameGenerator(allMember);
    var adjectiveList = List.of("하품하는", "씩씩한", "물구나무서는");
    var nounList = List.of("물개", "푸들", "이구아나");
    when(allMember.countContainNickname(anyString())).thenReturn(2L);

    System.out.println(nicknameGenerator.generate(adjectiveList, nounList));
    System.out.println(nicknameGenerator.generate(adjectiveList, nounList));
    System.out.println(nicknameGenerator.generate(adjectiveList, nounList));
  }
}