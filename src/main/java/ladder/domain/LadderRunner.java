package ladder.domain;

import ladder.domain.wrapper.CurrentPosition;
import ladder.domain.wrapper.LadderNumber;
import ladder.factory.LadderFactory;

public class LadderRunner {

    private Ladder ladder;

    public LadderRunner(Ladder ladder) {
        this.ladder = ladder;
    }

    public int run(LadderNumber ladderNum) {
        LadderViewer ladderViewer = LadderFactory.createLadderViewer(CurrentPosition.createCurrentPosition(ladderNum));

        for (int i = 0; i < ladder.getRowSize(); i++) {
            ladderViewer.getCurrentPosition().setX(i);
            ladderViewer.view("BEFORE");
            ladder.getRows()[i].nextPosition(ladderNum, ladderViewer.getCurrentPosition());
            ladderViewer.view("AFTER");
        }

        return ladderNum.getNumber();
    }

}
