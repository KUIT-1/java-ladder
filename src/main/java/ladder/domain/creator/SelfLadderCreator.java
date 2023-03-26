package ladder.domain.creator;

import ladder.domain.wrapper.NumberOfPerson;
import ladder.domain.wrapper.NumberOfRow;
import ladder.domain.Row;

public class SelfLadderCreator implements LadderCreator{

    private final Row[] rows;

    public SelfLadderCreator(NumberOfRow row, NumberOfPerson numberOfPerson) {
        rows = new Row[row.getNumberOfRow()];
        for (int i = 0; i < row.getNumberOfRow(); i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }

    @Override
    public void drawLine(int x, int leftY, int rightY) {
        rows[x].setValue(leftY, rightY);
    }

    @Override
    public Row[] getRows() {
        return rows;
    }
}
