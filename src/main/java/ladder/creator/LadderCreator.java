package ladder.creator;

import ladder.LadderPosition;
import ladder.LadderSize;
import ladder.Position;
import ladder.Row;

import static ladder.NaturalNumber.createNaturalNumber;

public class LadderCreator implements LadderCreatorInterface {

    Row[] rows;
    LadderSize ladderSize;

    public LadderCreator(LadderSize ladderSize) {
        this.ladderSize = ladderSize;

        rows = new Row[ladderSize.getRowValue() + 1];
        for (int i=1; i<=ladderSize.getRowValue(); i++) {
            rows[i] = new Row(createNaturalNumber(ladderSize.getNumberOfPersonValue()));
        }
    }

    @Override
    public void drawLine(LadderPosition ladderPosition) {
        validatePositionSize(ladderPosition.getX());
        rows[ladderPosition.getPositionX()].drawLine(ladderPosition.getY());
    }

    @Override
    public Row[] getRow() {
        return rows;
    }

    private void validatePositionSize(Position x) {
        if (!x.isSmaller(rows.length)) {
            throw new IllegalArgumentException("라인을 만들 행이 사다리 높이의 범위 안에 있어야 합니다.");
        }
    }
}
