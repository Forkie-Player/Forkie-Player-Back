package toolc.yourlist.playlist.infra;

import java.util.List;

record JsonUpdateSequenceRequest(Long playlistId, List<JsonPlaySequence> list) {
}
