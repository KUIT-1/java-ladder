package ladder.creator;

import ladder.NumberOfPerson;
import ladder.NumberOfRow;
import ladder.Row;

public class RandomLadderCreator implements LadderCreator{

    private final Row[] rows;

    public RandomLadderCreator(NumberOfRow row, NumberOfPerson numberOfPerson) {
        rows = new Row[row.getNumberOfRow()];
        for (int i = 0; i < row.getNumberOfRow(); i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }

    @Override
    public void drawLine(int x, int leftY, int rightY) {

    }

    @Override
    public Row[] getRows() {
        return rows;
    }
}
