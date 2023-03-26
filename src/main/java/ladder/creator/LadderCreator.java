package ladder.creator;

import ladder.wrapper.Row;

public interface LadderCreator {

    void drawLine(int x, int leftY, int rightY);

    Row[] getRows();

}
