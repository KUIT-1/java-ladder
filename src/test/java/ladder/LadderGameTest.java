package ladder;

import ladder.wrapper.LadderNumber;
import ladder.wrapper.Position;
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
    }

    @Test
    public void drawLineTest() throws Exception {
        //given
        position = WrapperFactory.createPosition(ladderGame.getLadderCreator(), 1, 1, 2);

        //when
        ladderGame.drawLine(position.getLeftPointXInt(), position.getLeftPointYInt(), position.getRightPointYInt());

        //then
        assertEquals(1, ladderGame.getRowsForTest()[1].getValue(1));
        assertEquals(-1, ladderGame.getRowsForTest()[1].getValue(2));
    }

    @Test
    public void runTest() throws Exception {
        //given
        position = WrapperFactory.createPosition(ladderGame.getLadderCreator(), 1, 1, 2);
        ladderGame.drawLine(position.getLeftPointXInt(), position.getLeftPointYInt(), position.getRightPointYInt());

        position = WrapperFactory.createPosition(ladderGame.getLadderCreator(), 2, 2, 3);
        ladderGame.drawLine(position.getLeftPointXInt(), position.getLeftPointYInt(), position.getRightPointYInt());

        //when
        int result = ladderGame.run(LadderNumber.createLadderNumber(1));

        //then
        assertEquals(3, result);
    }
}