package ladder;

import ladder.creator.LadderCreator;

import java.awt.*;

public class LadderPositionFactory {

    public static LadderGame createLadderGame(int row, int numberOfPerson) {
        return new LadderGame(NumberOfRow.createNumberOfPerson(row), NumberOfPerson.createNumberOfPerson(numberOfPerson));
    }

    public static LadderCreator createLadderCreator(NumberOfRow row, NumberOfPerson numberOfPerson) {
        return new LadderCreator(row, numberOfPerson);
    }

    public static LadderRunner createLadderRunner(LadderCreator ladderCreator) {
        return new LadderRunner(ladderCreator.getRows());
    }

    public static Position createPosition(LadderGame ladderGame, int x, int leftY, int rightY) {
        return new Position(new Point(x, leftY), new Point(x, rightY), ladderGame);
    }
}
