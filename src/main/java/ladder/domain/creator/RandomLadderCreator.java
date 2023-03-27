package ladder.domain.creator;

import ladder.domain.Ladder;
import ladder.domain.wrapper.Position;
import ladder.factory.WrapperFactory;

import java.util.Random;

public class RandomLadderCreator implements LadderCreator {

    private final Ladder ladder;
    private final LadderCreator selfLadderCreator;

    public RandomLadderCreator(Ladder ladder, LadderCreator selfLadderCreator) {
        this.ladder = ladder;
        this.selfLadderCreator = selfLadderCreator;
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

        Random random = new Random();
        random.setSeed(System.currentTimeMillis());

        for (int i = 0; i < count; i++) {
            RandomPosition randomPosition = RandomPosition.createRandomPosition();
            Position position = randomPosition.getPosition(ladder);
            selfLadderCreator.drawLine(position.getLeftPointXInt(),
                    position.getLeftPointYInt(), position.getRightPointYInt());
        }
    }

    @Override
    public Ladder getLadder() {
        return ladder;
    }
}
