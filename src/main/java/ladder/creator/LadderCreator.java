package ladder.creator;

import ladder.NaturalNumber;
import ladder.Position;
import ladder.Rows;

public class LadderCreator {
    private final Rows[] rows;

    public LadderCreator(NaturalNumber row, NaturalNumber numberOfPerson) {
        rows = new Rows[row.getNumber()];
        for (int i = 0; i < row.getNumber(); i++) {
            rows[i] = new Rows(numberOfPerson);
        }
    }

    public void drawLine(Position row, Position col) {
        row.minusPosition();
        col.minusPosition();
        validatePositionSize(row);
        rows[row.getPosition()].drawLine(col);
    }

    private void validatePositionSize(Position position) {
        if (!position.isSmaller(rows.length)) {
            throw new IllegalArgumentException("올바른 사다리의 위치가 아닙니다.");
        }
    }

    public Rows[] getRow() {
        return rows;
    }
}
