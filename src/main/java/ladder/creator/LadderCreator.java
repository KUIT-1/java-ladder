package ladder.creator;

import ladder.NumberOfPerson;
import ladder.NumberOfRow;
import ladder.Row;

public class LadderCreator {

    private final Row[] rows;

    public LadderCreator(NumberOfRow row, NumberOfPerson numberOfPerson) {
        rows = new Row[row.getNumberOfRow()];
        for (int i = 0; i < row.getNumberOfRow(); i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }

    public void drawLine(int x, int leftY, int rightY) {
        rows[x].setValue(leftY, rightY);
    }

    public Row[] getRows() {
        return rows;
    }
}
