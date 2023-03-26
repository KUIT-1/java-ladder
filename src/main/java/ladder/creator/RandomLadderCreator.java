package ladder.creator;

import ladder.wrapper.NumberOfPerson;
import ladder.wrapper.NumberOfRow;
import ladder.wrapper.Row;

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
