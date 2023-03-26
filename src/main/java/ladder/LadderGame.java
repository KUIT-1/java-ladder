package ladder;

import ladder.domain.Ladder;
import ladder.domain.creator.LadderCreator;
import ladder.domain.wrapper.LadderNumber;
import ladder.domain.wrapper.NumberOfPerson;
import ladder.domain.wrapper.NumberOfRow;
import ladder.domain.Row;
import ladder.factory.LadderFactory;

public class LadderGame {

    private LadderCreator ladderCreator;
    private Ladder ladder;

    public LadderGame(NumberOfRow row, NumberOfPerson numberOfPerson) {
        ladderCreator = LadderFactory.createRandomLadderCreator(row, numberOfPerson);
        ladder = ladderCreator.getLadder();
    }

    public int run(LadderNumber ladderNum) {
        return LadderFactory.createLadderRunner(ladderCreator).run(ladderNum);
    }

    public int getNumberOfPerson() {
        return ladder.getNumberOfPersonSize();
    }

    public int getRow() {
        return ladder.getRowSize();
    }

    public Ladder getLadder() {
        return ladder;
    }

    public LadderCreator getLadderCreator() {
        return ladderCreator;
    }
}
