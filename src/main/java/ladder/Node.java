package ladder;

import static ladder.Direction.*;

public class Node {
    private int state; // -1 : gotoLeft, 1 : gotoRight, 0 : gotoDown
    private int current_row;
    private int current_col;

    public Node(Position startPoint){
        this.state = DOWN.getDirection();
        this.current_row = 1;
        this.current_col = startPoint.getPosition();
    }

    public int move(LineManager lineManager) {
        this.state = lineManager.nextDirection(this.current_row, this.current_col, this.state);
        if(state == DOWN.getDirection()){
            gotoDown();
        }
        followLine();
        return this.current_col;
    }

    private void gotoDown() {
        this.current_row = this.current_row + 1;
    }

    private void followLine() {
        this.current_col = this.current_col + this.state;
    }

    public boolean isRowExceedValue(NaturalNumber value) {
        if(this.current_row > value.getNumber())
            return false;
        return true;
    }

}
