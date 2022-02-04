package toolc.yourlist.playlist.infra;

import toolc.yourlist.playlist.domain.Plays;

import java.util.List;
import java.util.stream.Collectors;

public class ListOfPlaysMapper {
  List<PlayJson> toPlayJsonList(Plays plays) {
    return plays.list()
      .stream()
      .map(PlayJson::new)
      .collect(Collectors.toList());
  }
}
