package ladder.domain;

import ladder.domain.wrapper.CurrentPosition;
import ladder.domain.wrapper.LadderNumber;

public class LadderRunner {

    private final Ladder ladder;

    private LadderRunner(Ladder ladder) {
        this.ladder = ladder;
    }

    public static LadderRunner of(Ladder ladder) {
        return new LadderRunner(ladder);
    }

    public void run(LadderNumber ladderNum) {
        LadderViewer ladderViewer = LadderViewer.of(CurrentPosition.createCurrentPosition(ladderNum), ladder);

        for (int i = 0; i < ladder.getRowSize(); i++) {
            ladderViewer.setCurrentPositionX(i);
            ladderViewer.view("BEFORE");
            ladder.nextPosition(i, ladderNum, ladderViewer.getCurrentPosition());
            ladderViewer.view("AFTER");
        }
    }

}
