package ladder;

import ladder.creator.RandomLadderCreator;

import static ladder.LadderPosition.createLadderPosition;
import static ladder.Position.createPosition;

public class RandomLadderGame {

    RandomLadderCreator randomLadderCreator;

    public RandomLadderGame(RandomLadderCreator randomLadderCreator) {
        this.randomLadderCreator = randomLadderCreator;
        randomLadderCreator.drawLine(createLadderPosition(createPosition(1), createPosition(1)));

    }

    public int run(Position position) {
        LadderRunner ladderRunner = new LadderRunner(randomLadderCreator.getRow());
        return ladderRunner.run(position);
    }
}