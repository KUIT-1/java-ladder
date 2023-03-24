package ladder;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LadderTest {

    static Ladder ladder;
    static Position position;

    @BeforeAll
    static void setLadderAndPosition() {
        ladder = LadderPositionFactory.createLadder(4, 5);
    }

    @Test
    public void drawLineTest() throws Exception {
        //given
        position = LadderPositionFactory.createPosition(ladder, 1, 1, 2);

        //when
        ladder.drawLine(position.getLeftPointXInt(), position.getLeftPointYInt(), position.getRightPointYInt());

        //then
        assertEquals(1, ladder.getRowsForTest()[1].getValue(1));
        assertEquals(-1, ladder.getRowsForTest()[1].getValue(2));
    }

    @Test
    public void runTest() throws Exception {
        //given
        position = LadderPositionFactory.createPosition(ladder, 1, 1, 2);
        ladder.drawLine(position.getLeftPointXInt(), position.getLeftPointYInt(), position.getRightPointYInt());

        position = LadderPositionFactory.createPosition(ladder, 2, 2, 3);
        ladder.drawLine(position.getLeftPointXInt(), position.getLeftPointYInt(), position.getRightPointYInt());

        //when
        int result = ladder.run(1);

        //then
        assertEquals(3, result);
    }
}