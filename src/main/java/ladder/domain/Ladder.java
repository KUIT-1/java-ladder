package ladder.domain;

import ladder.domain.wrapper.CurrentPosition;
import ladder.domain.wrapper.LadderNumber;
import ladder.domain.wrapper.NumberOfPerson;
import ladder.domain.wrapper.NumberOfRow;

public class Ladder {

    private final Row[] rows;

    private Ladder(NumberOfRow row, NumberOfPerson numberOfPerson) {
        rows = new Row[row.getNumberOfRow()];
        for (int i = 0; i < row.getNumberOfRow(); i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }

    public static Ladder of(NumberOfRow row, NumberOfPerson numberOfPerson) {
        return new Ladder(row, numberOfPerson);
    }

    public void nextPosition(int i, LadderNumber ladderNumber, CurrentPosition currentPosition) {
        rows[i].nextPosition(ladderNumber, currentPosition);
    }

    public void view(CurrentPosition currentPosition) {
        for (int i = 0; i < getRowSize(); i++) {
            rows[i].viewValues(getNumberOfPersonSize(), i, currentPosition);
        }
    }

    public void setLine(int x, int leftY, int rightY) {
        rows[x].setValue(leftY, rightY);
    }

    public Row[] getRows() {
        return rows;
    }

    public int getRowSize() {
        return rows.length;
    }

    public int getNumberOfPersonSize() {
        return rows[0].getLength();
    }
}
