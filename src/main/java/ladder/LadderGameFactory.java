package ladder;

import ladder.creator.LadderCreator;
import ladder.creator.LadderDefinedCreator;
import ladder.creator.LadderRandomCreator;

public class LadderGameFactory {
    LadderCreator ladderCreator;

    public static LadderGame createRandomLadderGame(NaturalNumber row, NaturalNumber numberOfPerson){
        LadderRandomCreator ladderCreator = new LadderRandomCreator(row, numberOfPerson);
        LadderGame ladderGame = new LadderGame(ladderCreator);
        return ladderGame;
    }

    public static LadderGame createDefinedLadderGame(NaturalNumber row, NaturalNumber numberOfPerson){
        LadderDefinedCreator ladderCreator = new LadderDefinedCreator(row, numberOfPerson);
        LadderGame ladderGame = new LadderGame(ladderCreator);
        return ladderGame;
    }
}
