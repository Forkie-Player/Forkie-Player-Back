package toolc.yourlist.play.infra;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;

import static toolc.yourlist.common.domain.Contracts.requires;

@Component
@RequiredArgsConstructor
public class PlaylistSaveDeserializer extends JsonDeserializer<PlaylistSaveRequest> {
  private final PlaylistSaveRequests playlistSaveRequests;

  @Override
  public PlaylistSaveRequest deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
    ObjectCodec codec = p.getCodec();
    JsonNode node = codec.readTree(p);

    requires(node.get("memberId") != null
      && node.get("title") != null, "필요값 X");

    Long memberId = node.get("memberId").asLong();
    String title = node.get("title").asText();

    return playlistSaveRequests.of(memberId, title);
  }
}
