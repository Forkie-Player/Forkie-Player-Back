package toolc.yourlist.playlist.infra;

import java.util.List;

record JsonUpdateSequenceRequest(Long memberId, Long playlistId, List<JsonPlaySequence> seqList) {
}
