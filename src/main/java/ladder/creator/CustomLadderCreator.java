package ladder.creator;

import ladder.LadderSize;
import ladder.Position;
import ladder.Row;

import static ladder.NaturalNumber.createNaturalNumber;

public class CustomLadderCreator implements  LadderCreator{
    Row[] rows;

    public CustomLadderCreator(LadderSize ladderSize) {
        rows = new Row[ladderSize.getNumOfRows()];
        for (int i = 0; i < ladderSize.getNumOfRows(); i++) {
            rows[i] = new Row(createNaturalNumber(ladderSize.getNumberOfPerson()));
        }
    }
    public void drawLine(Position row, Position col) {
        // (col, row) 위치에 라인을 만듦
        rows[row.getPosition()].drawLine(col);
    }

    @Override
    public void drawLine() {
        // unused
    }

    public Row[] getRows() {
        return rows;
    }
}
