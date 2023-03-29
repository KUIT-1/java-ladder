package ladder;

import org.junit.jupiter.api.Test;

import static ladder.LadderPosition.createLadderPosition;
import static ladder.Position.*;
import static ladder.Position.createPosition;
import static org.junit.jupiter.api.Assertions.*;

public class LadderPositionTest {
    @Test
    void getPositionValue() {
        Position x = createPosition(1);
        Position y = createPosition(2);
        LadderPosition ladderPosition = createLadderPosition(x, y);

        assertEquals(1, ladderPosition.getPositionX());
        assertEquals(2, ladderPosition.getPositionY());
    }

    @Test
    void equals() {
        LadderPosition ladderPosition1 = createLadderPosition(createPosition(1), createPosition(2));
        LadderPosition ladderPosition2 = createLadderPosition(createPosition(1), createPosition(2));
        LadderPosition ladderPosition3 = createLadderPosition(createPosition(1), createPosition(3));


        assertTrue(ladderPosition1.equals(ladderPosition2));
        assertFalse(ladderPosition1.equals(ladderPosition3));
    }
}
