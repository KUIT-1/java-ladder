package ladder.factory;

import ladder.LadderGame;
import ladder.domain.creator.LadderCreator;
import ladder.domain.creator.RandomLadderCreator;
import ladder.domain.creator.SelfLadderCreator;
import ladder.domain.LadderRunner;
import ladder.domain.wrapper.NumberOfPerson;
import ladder.domain.wrapper.NumberOfRow;

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
