package ladder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @Test
    public void testRowConstructor() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Row(0));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Row(-1));
        Assertions.assertDoesNotThrow(() -> new Row(1));
        Assertions.assertDoesNotThrow(() -> new Row(2));
        Assertions.assertDoesNotThrow(() -> new Row(1000));
    }

    @Test
    public void testDrawLine() {
        Row row = new Row(5);
        Assertions.assertThrows(IllegalArgumentException.class, () -> row.drawLine(-1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> row.drawLine(5));
        Assertions.assertDoesNotThrow(() -> row.drawLine(0));
        Assertions.assertDoesNotThrow(() -> row.drawLine(2));
    }

    @Test
    public void testNewPosition() {
        Row row = new Row(5);
        Row finalRow = row;
        Assertions.assertThrows(IllegalArgumentException.class, () -> finalRow.newPosition(-1));
        Row finalRow1 = row;
        Assertions.assertThrows(IllegalArgumentException.class, () -> finalRow1.newPosition(5));

        // Test a row without any lines
        int position = 0;
        Assertions.assertEquals(position, row.newPosition(position));
        position = 1;
        Assertions.assertEquals(position, row.newPosition(position));
        position = 2;
        Assertions.assertEquals(position, row.newPosition(position));
        position = 3;
        Assertions.assertEquals(position, row.newPosition(position));
        position = 4;
        Assertions.assertEquals(position, row.newPosition(position));

        // Test a row with a horizontal line at position 1
        row.drawLine(1);
        position = 0;
        Assertions.assertEquals(1, row.newPosition(position));
        position = 1;
        Assertions.assertEquals(position, row.newPosition(position));
        position = 2;
        Assertions.assertEquals(3, row.newPosition(position));
        position = 3;
        Assertions.assertEquals(position, row.newPosition(position));
        position = 4;
        Assertions.assertEquals(position, row.newPosition(position));

        // Test a row with a horizontal line at position 3
        row = new Row(5);
        row.drawLine(3);
        position = 0;
        Assertions.assertEquals(position, row.newPosition(position));
        position = 1;
        Assertions.assertEquals(position, row.newPosition(position));
        position = 2;
        Assertions.assertEquals(1, row.newPosition(position));
        position = 3;
        Assertions.assertEquals(position, row.newPosition(position));
        position = 4;
        Assertions.assertEquals(position, row.newPosition(position));

        // Test a row with vertical lines
        row = new Row(5);
        row.drawLine(1);
        row.drawLine(3);
        position = 0;
        Assertions.assertEquals(1, row.newPosition(position));
        position = 1;
        Assertions.assertEquals(position, row.newPosition(position));
        position = 2;
        Assertions.assertEquals(1, row.newPosition(position));
        position = 3;
        Assertions.assertEquals(position, row.newPosition(position));
        position = 4;
        Assertions.assertEquals(3, row.newPosition(position));
    }

}
