package toolc.yourlist.member.infra;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FileLoader {

  public static List<String> toStringList(String path) {
    try {
      return Files.lines(Paths.get(path)).toList();
    } catch (IOException e) {
      e.printStackTrace();
      return List.of();
    }
  }
}
