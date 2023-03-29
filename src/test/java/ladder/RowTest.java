package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RowTest {
    @Test
    @DisplayName("선 1개 타서 position change")
    void positionByMoveOneLine(){
        Row row=new Row(3);
        Position position= new Position(0);
        row.drawLine(0);
        row.nextPosition(position);
        assertEquals(1,position.getPosition());
    }



}
