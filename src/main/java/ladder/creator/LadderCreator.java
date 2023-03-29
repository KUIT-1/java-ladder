package ladder.creator;

import ladder.LadderPosition;
import ladder.Position;
import ladder.Rows;

public interface LadderCreator {
    Rows[] getRow();

    void drawLine(LadderPosition position);

    void validatePositionSize(Position position);

}
