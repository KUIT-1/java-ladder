package ladder.domain.creator;

import ladder.domain.Ladder;
import ladder.domain.wrapper.Position;
import ladder.factory.WrapperFactory;

public class RandomPosition {

    private RandomUtil randomUtil;

    private RandomPosition(RandomUtil randomUtil) {
        this.randomUtil = randomUtil;
    }

    public static RandomPosition createRandomPosition() {
        return new RandomPosition(RandomUtil.createRandomUtil());
    }

    public Position getPosition(Ladder ladder) {
        int randomX = randomUtil.generate(ladder.getRowSize());
        int randomY = randomUtil.generate(ladder.getNumberOfPersonSize() - 1);

        Position position;

        try {
            position = WrapperFactory.createPosition(ladder, randomX, randomY, randomY + 1);
        } catch (IllegalArgumentException e) {
            position = getPosition(ladder);
        }
        return position;
    }
}
