package ladder;

import static ladder.Direction.*;
import static ladder.Position.*;

public class Node {
    private Direction state; // -1 : gotoLeft, 1 : gotoRight, 0 : gotoDown
    private Position current_row = createPosition(1);
    private Position current_col;

    public Node(Position startPoint){
        this.state = DOWN;
        this.current_col = startPoint;
    }

    public Position move(LineManager lineManager) {
        this.state = lineManager.nextDirection(this.current_row, this.current_col, this.state);
        if(state == DOWN){
            gotoDown();
        }
        followLine();
        return this.current_col;
    }

    private void gotoDown() {
        this.current_row = this.current_row.nextPosition();
    }

    private void followLine() {
        this.current_col = createPosition(current_col.getPosition() + state.getDirection());

    }
    public boolean isRowExceedValue(NaturalNumber value) {
        if(this.current_row.getPosition() > value.getNumber())
            return false;
        return true;
    }
}
