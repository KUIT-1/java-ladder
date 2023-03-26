package ladder.domain;

import ladder.domain.wrapper.NumberOfPerson;
import ladder.domain.wrapper.NumberOfRow;

public class Ladder {

    private final Row[] rows;

    public Ladder(NumberOfRow row, NumberOfPerson numberOfPerson) {
        rows = new Row[row.getNumberOfRow()];
        for (int i = 0; i < row.getNumberOfRow(); i++) {
            rows[i] = new Row(numberOfPerson);
        }
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
