package toolc.yourlist.member.infra;

import org.junit.jupiter.api.Test;

class FileLoaderTest {
  @Test
  void toStringList() {
    var adjectiveList = FileLoader.toStringList("src/main/resources/adjective.txt");
    var nounList = FileLoader.toStringList("src/main/resources/noun.txt");

    System.out.println(adjectiveList);
    System.out.println(nounList);
  }
}