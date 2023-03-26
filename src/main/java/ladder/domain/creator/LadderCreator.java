package ladder.domain.creator;

import ladder.domain.Ladder;

public interface LadderCreator {

    void drawLine(int x, int leftY, int rightY);

    void drawLine();

    Ladder getLadder();

}
