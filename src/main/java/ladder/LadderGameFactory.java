package ladder;

import ladder.creator.CustomLadderCreator;
import ladder.creator.LadderCreator;
import ladder.creator.RandomLadderCreator;

public class LadderGameFactory {
    public LadderGame createCustomLadderGame(LadderSize ladderSize){
        LadderCreator ladderCreator = new CustomLadderCreator(ladderSize);
        return new LadderGame(ladderCreator);
    }
    public LadderGame createRandomLadderGame(LadderSize ladderSize){
        LadderCreator ladderCreator = new RandomLadderCreator(ladderSize);
        return new LadderGame(ladderCreator);
    }
}
