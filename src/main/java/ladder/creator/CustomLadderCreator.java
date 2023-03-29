package ladder.creator;

import ladder.LadderSize;
import ladder.Position;
import ladder.Row;

public class CustomLadderCreator implements  LadderCreator{
    Row[] rows;

    public CustomLadderCreator(LadderSize ladderSize) {
        rows = new Row[ladderSize.getRow().getNumber()];
        for (int i = 0; i < ladderSize.getRow().getNumber(); i++) {
            rows[i] = new Row(ladderSize.getNumberOfPerson());
        }
    }
    public void drawLine(Position row, Position col) {
        // (col, row) 위치에 라인을 만듦
        rows[row.getPosition()].drawLine(col);
    }

    public Row[] getRows() {
        return rows;
    }
}
