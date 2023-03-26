package ladder.domain.creator;

import ladder.domain.Ladder;
import ladder.domain.Row;

public interface LadderCreator {

    void drawLine(int x, int leftY, int rightY);

    Ladder getLadder();

}
