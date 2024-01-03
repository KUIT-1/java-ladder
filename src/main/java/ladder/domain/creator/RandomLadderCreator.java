package ladder.domain.creator;

import ladder.domain.Ladder;
import ladder.domain.wrapper.Rung;

import java.util.Set;

public class RandomLadderCreator implements LadderCreator {

    private final Ladder ladder;
    private final LadderCreator selfLadderCreator;

    public RandomLadderCreator(Ladder ladder, LadderCreator selfLadderCreator) {
        this.ladder = ladder;
        this.selfLadderCreator = selfLadderCreator;
        drawLine();
    }

    /**
     * @deprecated
     */
    @Override
    public void drawLine(int x, int leftY, int rightY) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void drawLine() {
        int count = (int) (ladder.getRowSize() * ladder.getNumberOfPersonSize() * 0.3);

        Set<Rung> randomRungs = RandomRung.getRandomRungs(ladder, count);

        randomRungs.forEach(position -> selfLadderCreator.drawLine(position.getLeftPointXInt(),
                position.getLeftPointYInt(), position.getRightPointYInt()));
    }

    @Override
    public Ladder getLadder() {
        return ladder;
    }
}
