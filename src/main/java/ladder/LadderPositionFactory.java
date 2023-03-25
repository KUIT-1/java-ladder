package ladder;

import ladder.creator.SelfLadderCreator;

import java.awt.*;

public class LadderPositionFactory {

    public static LadderGame createLadderGame(int row, int numberOfPerson) {
        return new LadderGame(NumberOfRow.createNumberOfPerson(row), NumberOfPerson.createNumberOfPerson(numberOfPerson));
    }

    public static SelfLadderCreator createLadderCreator(NumberOfRow row, NumberOfPerson numberOfPerson) {
        return new SelfLadderCreator(row, numberOfPerson);
    }

    public static LadderRunner createLadderRunner(SelfLadderCreator selfLadderCreator) {
        return new LadderRunner(selfLadderCreator.getRows());
    }

    public static Position createPosition(LadderGame ladderGame, int x, int leftY, int rightY) {
        return new Position(new Point(x, leftY), new Point(x, rightY), ladderGame);
    }
}
