package ladder.domain.creator;

import ladder.domain.Row;

public interface LadderCreator {

    void drawLine(int x, int leftY, int rightY);

    Row[] getRows();

}
