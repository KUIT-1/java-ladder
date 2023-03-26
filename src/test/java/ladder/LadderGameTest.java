package ladder;

import ladder.domain.wrapper.LadderNumber;
import ladder.domain.wrapper.Position;
import ladder.factory.LadderFactory;
import ladder.factory.WrapperFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LadderGameTest {

    static LadderGame ladderGame;
    static Position position;

//    @BeforeAll
    static void setLadderAndPosition() {
        ladderGame = LadderFactory.createLadderGame(4, 5);
    }

    @BeforeEach
    void reset() {
        ladderGame = LadderFactory.createLadderGame(4, 5);
        LadderFactory.resetLadder();
    }

    @Test
    public void drawLineTest() throws Exception {
        //given
        position = WrapperFactory.createPosition(ladderGame.getLadder(), 1, 1, 2);

        //when
        ladderGame.drawLine(position.getLeftPointXInt(), position.getLeftPointYInt(), position.getRightPointYInt());

        //then
        assertEquals(1, ladderGame.getLadder().getRows()[1].getValue(1));
        assertEquals(-1, ladderGame.getLadder().getRows()[1].getValue(2));
    }

    @Test
    public void runTest() throws Exception {
        //given
        position = WrapperFactory.createPosition(ladderGame.getLadder(), 1, 1, 2);
        ladderGame.drawLine(position.getLeftPointXInt(), position.getLeftPointYInt(), position.getRightPointYInt());

        position = WrapperFactory.createPosition(ladderGame.getLadder(), 2, 2, 3);
        ladderGame.drawLine(position.getLeftPointXInt(), position.getLeftPointYInt(), position.getRightPointYInt());

        //when
        int result = ladderGame.run(LadderNumber.createLadderNumber(1));

        //then
        assertEquals(3, result);
    }
}