package ladder.domain.creator;

import ladder.domain.Ladder;

public class SelfLadderCreator implements LadderCreator{

    private final Ladder ladder;

    public SelfLadderCreator(Ladder ladder) {
        this.ladder = ladder;
    }

    @Override
    public void drawLine(int x, int leftY, int rightY) {
        ladder.getRows()[x].setValue(leftY, rightY);
    }

    /**
     * @deprecated
     */
    @Override
    public void drawLine() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Ladder getLadder() {
        return ladder;
    }
}
