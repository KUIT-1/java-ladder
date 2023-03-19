package ladder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LadderTest {

    @Test
    public void drawLineTest() throws Exception {
        //given
        Ladder ladder = ApplicationInit.createLadder(4, 5);
        Position position = ApplicationInit.createPosition(1, 1, 1, 2);

        //when
        ladder.drawLine(position);

        //then
        assertEquals(1, ladder.getRowsForTest()[1][1]);
        assertEquals(-1, ladder.getRowsForTest()[1][2]);
    }

    @Test
    public void runTest() throws Exception {
        //given
        Ladder ladder = ApplicationInit.createLadder(4, 5);

        ladder.drawLine(ApplicationInit.createPosition(1, 1, 1, 2));
        ladder.drawLine(ApplicationInit.createPosition(2, 2, 2, 3));

        //when
        int result = ladder.run(1);

        //then
        assertEquals(3, result);
    }
}