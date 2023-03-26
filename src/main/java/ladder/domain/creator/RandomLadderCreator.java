package ladder.domain.creator;

import ladder.domain.Ladder;

public class RandomLadderCreator implements LadderCreator{

    private final Ladder ladder;

    public RandomLadderCreator(Ladder ladder) {
        this.ladder = ladder;
    }

    @Override
    public void drawLine(int x, int leftY, int rightY) {

    }

    @Override
    public Ladder getLadder() {
        return ladder;
    }
}
