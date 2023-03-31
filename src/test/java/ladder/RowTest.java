package ladder;

import org.junit.Test;
import static org.junit.Assert.*;

public class RowTest {

    @Test
    public void testGetRowString() {
        Row row = new Row(5);
        row.drawLine(1);
        row.drawLine(3);
        assertEquals("|-|-|", row.getRowString());
    }

    @Test
    public void testDrawLine() {
        Row row = new Row(5);
        row.drawLine(2);
        assertEquals("|--| |", row.getRowString());
    }

    @Test
    public void testNewPosition() {
        Row row = new Row(5);
        row.drawLine(1);
        row.drawLine(3);
        assertEquals(2, row.newPosition(2));
    }
}
