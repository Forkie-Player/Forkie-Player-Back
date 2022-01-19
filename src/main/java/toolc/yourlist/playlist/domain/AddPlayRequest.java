package toolc.yourlist.playlist.domain;

public record AddPlayRequest(EqualOwner equalOwner, PlayInfo info, PlayTime time, Channel channel) {
}
