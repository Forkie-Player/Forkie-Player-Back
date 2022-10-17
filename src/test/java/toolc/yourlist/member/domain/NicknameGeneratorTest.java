package toolc.yourlist.member.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class NicknameGeneratorTest {

  @Test
  void generate(@Mock AllMember allMember, @Mock WordProvidable wordProvidable) {
    var adjectiveList = List.of("하품하는", "씩씩한", "물구나무서는");
    var nounList = List.of("물개", "푸들", "이구아나");
    when(allMember.countContainNickname(anyString())).thenReturn(0L);
    when(wordProvidable.getAdjectiveList()).thenReturn(adjectiveList);
    when(wordProvidable.getNounList()).thenReturn(nounList);
    var nicknameGenerator = new NicknameGenerator(allMember, wordProvidable);

    System.out.println(nicknameGenerator.generate());
    verify(allMember, times(1)).countContainNickname(anyString());
    verify(wordProvidable, times(1)).getAdjectiveList();
    verify(wordProvidable, times(1)).getNounList();
  }

  @Test
  void generate_duplicate_nickname(@Mock AllMember allMember, @Mock WordProvidable wordProvidable) {
    var adjectiveList = List.of("하품하는", "씩씩한", "물구나무서는");
    var nounList = List.of("물개", "푸들", "이구아나");
    when(allMember.countContainNickname(anyString())).thenReturn(2L);
    when(wordProvidable.getAdjectiveList()).thenReturn(adjectiveList);
    when(wordProvidable.getNounList()).thenReturn(nounList);
    var nicknameGenerator = new NicknameGenerator(allMember, wordProvidable);

    System.out.println(nicknameGenerator.generate());
    verify(allMember, times(2)).countContainNickname(anyString());
    verify(wordProvidable, times(1)).getAdjectiveList();
    verify(wordProvidable, times(1)).getNounList();
  }
}