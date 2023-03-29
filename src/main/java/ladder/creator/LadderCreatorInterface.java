package ladder.creator;

import ladder.LadderPosition;
import ladder.Row;

public interface LadderCreatorInterface {
    void drawLine(LadderPosition ladderPosition);
    Row[] getRow();
}
