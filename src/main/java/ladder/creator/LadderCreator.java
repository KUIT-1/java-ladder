package ladder.creator;

import ladder.NaturalNumber;
import ladder.Position;
import ladder.Row;

public class LadderCreator {
     Row[] rows;

    public LadderCreator(NaturalNumber row, NaturalNumber numberOfPerson) {
        rows = new Row[row.getNumber()];
        for (int i = 0; i < row.getNumber(); i++) {
            rows[i] = new Row(numberOfPerson);
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
