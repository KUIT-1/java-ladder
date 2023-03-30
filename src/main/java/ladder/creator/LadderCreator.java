package ladder.creator;

import ladder.lineinfo.LineByRow;
import ladder.Position;

public interface LadderCreator {
    boolean drawLine(Position row, Position col);
    boolean validateLine(Position row, Position col);
    LineByRow[] getLineByRows();
}