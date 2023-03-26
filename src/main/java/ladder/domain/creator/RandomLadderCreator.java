package ladder.domain.creator;

import ladder.domain.Ladder;
import ladder.domain.wrapper.Position;
import ladder.factory.WrapperFactory;

import java.util.Random;

public class RandomLadderCreator implements LadderCreator {

    private final Ladder ladder;
    private final SelfLadderCreator selfLadderCreator;

    public RandomLadderCreator(Ladder ladder, SelfLadderCreator selfLadderCreator) {
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
            i = createRandomDrawLine(random, i);
        }
    }

    private int createRandomDrawLine(Random random, int i) {
        int randomX = random.nextInt(ladder.getRowSize());
        int randomY = random.nextInt(ladder.getNumberOfPersonSize() - 1);

        try {
            Position position = WrapperFactory.createPosition(ladder, randomX, randomY, randomY + 1);
            selfLadderCreator.drawLine(position.getLeftPointXInt(), position.getLeftPointYInt(), position.getRightPointYInt());
        } catch (IllegalArgumentException e) {
            return --i;
        }
        return i;
    }


    @Override
    public Ladder getLadder() {
        return ladder;
    }
}
