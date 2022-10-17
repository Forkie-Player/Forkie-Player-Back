package toolc.yourlist.member.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.member.domain.WordProvidable;

import java.util.List;

@RequiredArgsConstructor
public class WordProvider implements WordProvidable {

  private final JpaAllAdjectiveEntity jpaAllAdjectiveEntity;
  private final JpaAllNounEntity jpaAllNounEntity;

  @Override
  public List<String> getNounList() {
    return jpaAllNounEntity.findAllContent();
  }

  @Override
  public List<String> getAdjectiveList() {
    return jpaAllAdjectiveEntity.findAllContent();
  }
}
