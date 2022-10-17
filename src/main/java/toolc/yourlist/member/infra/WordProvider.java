package toolc.yourlist.member.infra;

import toolc.yourlist.member.domain.WordProvidable;

import java.util.List;

public class WordProvider implements WordProvidable {
  @Override
  public List<String> getNounList() {
    return null;
  }

  @Override
  public List<String> getAdjectiveList() {
    return null;
  }
}
