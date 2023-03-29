package ladder.creator;

import ladder.LadderPosition;
import ladder.LadderSize;
import ladder.Position;
import ladder.Rows;

public class GeneralLadderCreator implements LadderCreator{
    private final Rows[] rows;

    public GeneralLadderCreator(LadderSize ladderSize) {
        rows = new Rows[ladderSize.getRowSize().getNumber()];
        for (int i = 0; i < ladderSize.getRowSize().getNumber(); i++) {
            rows[i] = new Rows(ladderSize.getColSize());
        }
    }

    @Override
    public Rows[] getRow() {
        return rows;
    }

    @Override
    public void drawLine(LadderPosition position) {
        position.getRowPosition().minusPosition();
        position.getColPosition().minusPosition();
        validatePositionSize(position.getRowPosition());
        rows[position.getRowPosition().getPosition()].drawLine(position.getColPosition());
    }

    @Override
    public void validatePositionSize(Position position) {
        if (!position.isSmaller(rows.length)) {
            throw new IllegalArgumentException("올바른 사다리의 위치가 아닙니다.");
        }
    }
}
