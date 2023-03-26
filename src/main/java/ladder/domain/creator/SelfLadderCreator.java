package ladder.domain.creator;

import ladder.domain.Ladder;
import ladder.domain.wrapper.NumberOfPerson;
import ladder.domain.wrapper.NumberOfRow;
import ladder.domain.Row;

public class SelfLadderCreator implements LadderCreator{

    private final Ladder ladder;

    public SelfLadderCreator(Ladder ladder) {
        this.ladder = ladder;
    }

    @Override
    public void drawLine(int x, int leftY, int rightY) {
        ladder.getRows()[x].setValue(leftY, rightY);
    }

    @Override
    public Ladder getLadder() {
        return ladder;
    }
}
