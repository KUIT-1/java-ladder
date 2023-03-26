package ladder.domain;

import ladder.domain.wrapper.CurrentPosition;

public class LadderViewer {

    private final CurrentPosition currentPosition;
    private final Ladder ladder;

    private LadderViewer(CurrentPosition currentPosition, Ladder ladder) {
        this.currentPosition = currentPosition;
        this.ladder = ladder;
    }

    public static LadderViewer createLadderViewer(CurrentPosition currentPosition, Ladder ladder) {
        return new LadderViewer(currentPosition, ladder);
    }

    public void view(String message) {
        System.out.println(message);
        Row[] rows = ladder.getRows();
        for (int i = 0; i < ladder.getRowSize(); i++) {
            rows[i].viewValues(ladder.getNumberOfPersonSize(), i, currentPosition);
        }
        System.out.println();
    }

    public CurrentPosition getCurrentPosition() {
        return currentPosition;
    }
}
