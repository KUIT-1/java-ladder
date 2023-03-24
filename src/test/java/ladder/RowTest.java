package ladder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RowTest {
    @Test
    void drawLineTest() {
        Row row = new Row(5);
        assertFalse(row.isLineDrawn(1));
        assertFalse(row.isLineDrawn(3));

        row.drawLine(1);
        row.drawLine(3);

        assertTrue(row.isLineDrawn(1));
        assertFalse(row.isLineDrawn(2));
        assertTrue(row.isLineDrawn(3));
    }

    @Test
    void invalidPositionTest() {
        Row row = new Row(5);

        assertThrows(IllegalArgumentException.class, () -> {
            row.isLineDrawn(0);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            row.isLineDrawn(6);
        });
    }
}
