package ladder.creator;

import ladder.Position;
import ladder.Row;

public interface LadderCreator {
    public abstract void drawLine(Position row, Position col);
    public abstract Row[] getRow();

}
