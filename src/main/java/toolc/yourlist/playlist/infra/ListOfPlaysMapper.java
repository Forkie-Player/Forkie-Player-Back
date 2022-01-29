package toolc.yourlist.playlist.infra;

import toolc.yourlist.playlist.domain.ListOfPlays;

import java.util.List;
import java.util.stream.Collectors;

public class ListOfPlaysMapper {
  List<PlayJson> toPlayJsonList(ListOfPlays listOfPlays) {
    return listOfPlays.list()
      .stream()
      .map(PlayJson::new)
      .collect(Collectors.toList());
  }
}
