package ladder.creator;

import ladder.NumberOfPerson;
import ladder.NumberOfRow;
import ladder.Row;

public interface LadderCreator {

    void drawLine(int x, int leftY, int rightY);

    Row[] getRows();

}
