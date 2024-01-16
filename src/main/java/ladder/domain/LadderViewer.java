package ladder.domain;

import ladder.domain.wrapper.CurrentPosition;

public class LadderViewer {

    private final CurrentPosition currentPosition;
    private final Ladder ladder;

    private LadderViewer(CurrentPosition currentPosition, Ladder ladder) {
        this.currentPosition = currentPosition;
        this.ladder = ladder;
    }

    public static LadderViewer of(CurrentPosition currentPosition, Ladder ladder) {
        return new LadderViewer(currentPosition, ladder);
    }

    public void view(CurrentPosition currentPosition) {
        for (int i = 0; i < ladder.getRowSize(); i++) {
            setCurrentPositionX(i);
            viewLadder("BEFORE");
            ladder.nextPosition(i, currentPosition);
            viewLadder("AFTER");
        }
    }

    private void viewLadder(String message) {
        System.out.println(message);
        ladder.view(currentPosition);
        System.out.println();
    }

    public void setCurrentPositionX(int i) {
        currentPosition.setX(i);
    }
}
