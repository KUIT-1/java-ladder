package ladder.domain;

import ladder.LadderGame;
import ladder.domain.wrapper.LadderNumber;
import ladder.factory.LadderGameFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadderGameTest {

    @Test
    public void runTest() throws Exception {
        //given
        LadderGame ladderGame = LadderGameFactory.createRandomLadderGame(4, 5);

        //then
        ladderGame.run(LadderNumber.of(1));
    }
}