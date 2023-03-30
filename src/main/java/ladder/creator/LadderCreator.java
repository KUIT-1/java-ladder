package ladder.creator;

import ladder.LineByRow;
import ladder.Position;

public interface LadderCreatorInterface{
    boolean drawLine(Position row, Position col);
    boolean validateLine(Position row, Position col);
    LineByRow[] getLineByRows();
}