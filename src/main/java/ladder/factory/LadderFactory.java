package ladder.factory;

import ladder.LadderGame;
import ladder.domain.Ladder;
import ladder.domain.LadderViewer;
import ladder.domain.creator.LadderCreator;
import ladder.domain.creator.RandomLadderCreator;
import ladder.domain.creator.SelfLadderCreator;
import ladder.domain.LadderRunner;
import ladder.domain.wrapper.CurrentPosition;
import ladder.domain.wrapper.NumberOfPerson;
import ladder.domain.wrapper.NumberOfRow;

public class LadderFactory {

    private static Ladder ladder;

    public static LadderGame createLadderGame(int row, int numberOfPerson) {
        return new LadderGame(NumberOfRow.createNumberOfRow(row), NumberOfPerson.createNumberOfPerson(numberOfPerson));
    }

    public static LadderCreator createSelfLadderCreator(NumberOfRow row, NumberOfPerson numberOfPerson) {
        if (ladder == null) {
            new SelfLadderCreator(createLadder(row, numberOfPerson));
        }
        return new SelfLadderCreator(ladder);
    }

    public static LadderCreator createRandomLadderCreator(NumberOfRow row, NumberOfPerson numberOfPerson) {
        LadderCreator selfLadderCreator = createSelfLadderCreator(row, numberOfPerson);
        if (ladder == null) {
            new RandomLadderCreator(createLadder(row, numberOfPerson), selfLadderCreator);
        }
        return new RandomLadderCreator(ladder, selfLadderCreator);
    }

    public static LadderRunner createLadderRunner(LadderCreator LadderCreator) {
        return new LadderRunner(LadderCreator.getLadder());
    }

    private static Ladder createLadder(NumberOfRow row, NumberOfPerson numberOfPerson) {
        ladder = new Ladder(row, numberOfPerson);
        return ladder;
    }

    public static void resetLadder() {
        ladder = createLadder(NumberOfRow.createNumberOfRow(ladder.getRowSize()),
                NumberOfPerson.createNumberOfPerson(ladder.getNumberOfPersonSize()));
    }

    public static LadderViewer createLadderViewer(CurrentPosition currentPosition) {
        return LadderViewer.createLadderViewer(currentPosition, ladder);
    }

}
