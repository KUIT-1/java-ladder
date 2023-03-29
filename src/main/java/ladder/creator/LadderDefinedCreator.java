package ladder.creator;

import ladder.NaturalNumber;
import ladder.Position;
import ladder.Row;

public class LadderDefinedCreator implements LadderCreator{

    private final Row[] rows;

    public LadderDefinedCreator(NaturalNumber row, NaturalNumber numberOfPerson) {
        rows = new Row[row.getNumber()];
        for (int i = 0; i < row.getNumber(); i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }

    @Override
    public void drawLine(Position row, Position col) {
        rows[row.getPosition()].drawLine(col);
    }

    @Override
    public Row[] getRow() {
        return rows;
    }
}