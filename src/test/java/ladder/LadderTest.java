package ladder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @Test
    public void testLadder() {
        // Given
        Ladder ladder = new Ladder(3, 5);

        // When
        ladder.drawLine(0, 0);
        ladder.drawLine(1, 1);
        ladder.drawLine(2, 2);

        // Then
        Assertions.assertEquals(0, ladder.run(0));
        Assertions.assertEquals(1, ladder.run(1));
        Assertions.assertEquals(2, ladder.run(2));
        Assertions.assertEquals(3, ladder.run(3));
        Assertions.assertEquals(4, ladder.run(4));
    }

    @Test
    public void testInvalidDrawLine() {
        // Given
        Ladder ladder = new Ladder(3, 5);

        // When and Then
        Assertions.assertThrows(IllegalArgumentException.class, () -> ladder.drawLine(-1, 0));
        Assertions.assertThrows(IllegalArgumentException.class, () -> ladder.drawLine(0, -1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> ladder.drawLine(3, 0));
        Assertions.assertThrows(IllegalArgumentException.class, () -> ladder.drawLine(0, 5));
    }

    @Test
    public void testInvalidRun() {
        // Given
        Ladder ladder = new Ladder(3, 5);

        // When and Then
        Assertions.assertThrows(IllegalArgumentException.class, () -> ladder.run(-1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> ladder.run(5));
    }

}
