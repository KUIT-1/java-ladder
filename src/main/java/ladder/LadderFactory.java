package ladder;

import ladder.creator.LadderCreator;
import ladder.creator.RandomLadderCreator;
import ladder.creator.SelfLadderCreator;

public class LadderFactory {

    public static LadderGame createLadderGame(int row, int numberOfPerson) {
        return new LadderGame(NumberOfRow.createNumberOfPerson(row), NumberOfPerson.createNumberOfPerson(numberOfPerson));
    }

    public static LadderCreator createSelfLadderCreator(NumberOfRow row, NumberOfPerson numberOfPerson) {
        return new SelfLadderCreator(row, numberOfPerson);
    }

    public static LadderCreator createRandomLadderCreator(NumberOfRow row, NumberOfPerson numberOfPerson) {
        return new RandomLadderCreator(row, numberOfPerson);
    }

    public static LadderRunner createLadderRunner(LadderCreator LadderCreator) {
        return new LadderRunner(LadderCreator.getRows());
    }

}
