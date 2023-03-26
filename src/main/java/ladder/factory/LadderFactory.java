package ladder.factory;

import ladder.LadderGame;
import ladder.domain.Ladder;
import ladder.domain.creator.LadderCreator;
import ladder.domain.creator.RandomLadderCreator;
import ladder.domain.creator.SelfLadderCreator;
import ladder.domain.LadderRunner;
import ladder.domain.wrapper.NumberOfPerson;
import ladder.domain.wrapper.NumberOfRow;

public class LadderFactory {

    private static Ladder ladder;

    public static LadderGame createLadderGame(int row, int numberOfPerson) {
        return new LadderGame(NumberOfRow.createNumberOfPerson(row), NumberOfPerson.createNumberOfPerson(numberOfPerson));
    }

    public static LadderCreator createSelfLadderCreator(NumberOfRow row, NumberOfPerson numberOfPerson) {
        if (ladder == null) {
            ladder = createLadder(row, numberOfPerson);
            new SelfLadderCreator(ladder);
        }
        return new SelfLadderCreator(ladder);
    }

    public static LadderCreator createRandomLadderCreator(NumberOfRow row, NumberOfPerson numberOfPerson) {
        if (ladder == null) {
            ladder = createLadder(row, numberOfPerson);
            new RandomLadderCreator(ladder);
        }
        return new RandomLadderCreator(ladder);
    }

    public static LadderRunner createLadderRunner(LadderCreator LadderCreator) {
        return new LadderRunner(LadderCreator.getLadder());
    }

    private static Ladder createLadder(NumberOfRow row, NumberOfPerson numberOfPerson) {
        ladder = new Ladder(row, numberOfPerson);
        return ladder;
    }

    public static LadderCreator resetLadder(LadderCreator ladderCreator) {
        ladder = createLadder(NumberOfRow.createNumberOfPerson(ladder.getRowSize()),
                NumberOfPerson.createNumberOfPerson(ladder.getNumberOfPersonSize()));
        return new RandomLadderCreator(ladder);
    }

}
