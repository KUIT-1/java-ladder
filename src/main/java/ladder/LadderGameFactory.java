package ladder;

import ladder.creator.ManualLadderCreator;
import ladder.creator.LadderCreator;
import ladder.creator.RandomLadderCreator;

public class LadderGameFactory {
    public LadderGame createCustomLadderGame(LadderSize ladderSize){
        LadderCreator ladderCreator = new ManualLadderCreator(ladderSize);
        return new LadderGame(ladderCreator);
    }
    public LadderGame createRandomLadderGame(LadderSize ladderSize){
        LadderCreator ladderCreator = new RandomLadderCreator(ladderSize);
        return new LadderGame(ladderCreator);
    }
}
