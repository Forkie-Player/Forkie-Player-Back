package toolc.yourlist.playlist.domain;

import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;

@RequiredArgsConstructor
public class SequenceUpdater {
  private final AllPlay allPlay;
  private final ChangeThumbnail changeThumbnail;

  @Transactional
  public void update(PlaySequencesForUpdate request) {
    request.forEach(playSequence -> {
      var play = playSequence.validRequestForPlay().get();
      var sequenceToChange = playSequence.sequenceToChange();

      allPlay.updateSequence(play.id(), sequenceToChange);

      changeThumbnail.changeForUpdateSequence(play, sequenceToChange);
    });
  }

  @Transactional
  public void updateWithDelete(Plays plays, Long deleteSequence) {
    plays.forEach(play -> {
      if(play.sequence() > deleteSequence) {
        var sequenceToChange = play.sequence() - 1;

        allPlay.updateSequence(play.id(), sequenceToChange);

        changeThumbnail.changeForUpdateSequence(play, sequenceToChange);
      }
    });
  }
}
