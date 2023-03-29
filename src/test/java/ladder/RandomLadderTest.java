package ladder;

import org.junit.jupiter.api.Test;

import static ladder.NaturalNumber.createNaturalNumber;
import static ladder.Position.createPosition;

public class RandomLadderTest {
    @Test
    void randomLadderTest() {
        NaturalNumber row = createNaturalNumber(5);
        NaturalNumber numberOfPerson = createNaturalNumber(5);
        LadderSize ladderSize = LadderSize.createLadderSize(row, numberOfPerson);
        RandomLadderGame randomLadderGame = LadderGameFactory.createRandomLadderGame(ladderSize);

        randomLadderGame.run(createPosition(2));
    }
}
