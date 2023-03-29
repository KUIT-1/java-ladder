package ladder;

import ladder.creator.LadderCreator;
import ladder.creator.RandomLadderCreator;

public class LadderGameFactory {

    static LadderGame createLadderGame(LadderSize ladderSize) {
        LadderCreator ladderCreator = new LadderCreator(ladderSize);
        LadderGame ladderGame = new LadderGame(ladderCreator);

        return ladderGame;
    }

    static RandomLadderGame createRandomLadderGame(LadderSize ladderSize) {
        RandomLadderCreator randomLadderCreator = new RandomLadderCreator(ladderSize);
        RandomLadderGame randomLadderGame = new RandomLadderGame(randomLadderCreator);

        return randomLadderGame;
    }
}
