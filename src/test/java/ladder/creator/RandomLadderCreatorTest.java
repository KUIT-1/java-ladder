package ladder.creator;

import ladder.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static ladder.NaturalNumber.createNaturalNumber;
import static ladder.Position.createPosition;

class RandomLadderCreatorTest {
    LadderSize ladderSize;
    LadderGameFactory ladderGameFactory;
    LadderGame ladderGame;
    StringManager stringManager = new StringManager();

    public void init(NaturalNumber row, NaturalNumber col) {
        ladderSize = LadderSize.createLadderSize(row, col);
        ladderGameFactory = new LadderGameFactory();
        ladderGame = ladderGameFactory.createRandomLadderGame(ladderSize);
    }

    @Test
    @DisplayName("create random ladder")
    public void randomLadderCreatorTest(){
        init(createNaturalNumber(5), createNaturalNumber(5));
        Position destPosition = ladderGame.run(createPosition(0));
        System.out.println(stringManager.getResultString(destPosition));
    }
}