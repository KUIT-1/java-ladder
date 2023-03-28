package ladder;

import ladder.domain.Ladder;
import ladder.domain.creator.LadderCreator;
import ladder.domain.wrapper.LadderNumber;
import ladder.factory.LadderFactory;

public class LadderGame {

    private LadderCreator ladderCreator;
    private Ladder ladder;

    public LadderGame(LadderCreator ladderCreator, Ladder ladder) {
        this.ladderCreator = ladderCreator;
        this.ladder = ladder;
    }

    public int run(LadderNumber ladderNum) {
        return LadderFactory.createLadderRunner(ladderCreator).run(ladderNum);
    }

    public Ladder getLadder() {
        return ladder;
    }

    public LadderCreator getLadderCreator() {
        return ladderCreator;
    }
}
