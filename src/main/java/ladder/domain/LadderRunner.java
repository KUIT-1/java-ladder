package ladder.domain;

import ladder.domain.wrapper.CurrentPosition;

public class LadderRunner {

    private final Ladder ladder;

    private LadderRunner(Ladder ladder) {
        this.ladder = ladder;
    }

    public static LadderRunner of(Ladder ladder) {
        return new LadderRunner(ladder);
    }

    public void run(CurrentPosition currentPosition) {
        LadderViewer ladderViewer = LadderViewer.of(ladder);

        for (int i = 0; i < ladder.getRowSize(); i++) {
            currentPosition.setX(i);
            ladderViewer.view("BEFORE", currentPosition);
            ladder.nextPosition(i, currentPosition);
            ladderViewer.view("AFTER", currentPosition);
        }
    }

}
