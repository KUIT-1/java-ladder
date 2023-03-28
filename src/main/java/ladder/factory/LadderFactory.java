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

    public static LadderGame createLadderGame(LadderCreator ladderCreator) {
        ladder = ladderCreator.getLadder();
        return new LadderGame(ladderCreator, ladder);
    }

    public static LadderCreator createSelfLadderCreator(int row, int numberOfPerson) {
        return new SelfLadderCreator(createLadder(
                NumberOfRow.createNumberOfRow(row), NumberOfPerson.createNumberOfPerson(numberOfPerson)));
    }

    public static LadderCreator createRandomLadderCreator(int row, int numberOfPerson) {
        LadderCreator selfLadderCreator = createSelfLadderCreator(row, numberOfPerson);
        return new RandomLadderCreator(ladder, selfLadderCreator);
    }

    public static LadderRunner createLadderRunner(LadderCreator LadderCreator) {
        return new LadderRunner(LadderCreator.getLadder());
    }

    private static Ladder createLadder(NumberOfRow row, NumberOfPerson numberOfPerson) {
        ladder = new Ladder(row, numberOfPerson);
        return ladder;
    }

    public static LadderViewer createLadderViewer(CurrentPosition currentPosition) {
        return LadderViewer.createLadderViewer(currentPosition, ladder);
    }

}
