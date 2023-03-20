package ladder;

public class Node {
    private int state; // -1 : gotoLeft, 1 : gotoRight, 0 : gotoDown
    private int row;
    private int col;

    public Node(int startPoint){
        this.state = 0;
        this.row = 1;
        this.col = startPoint;
    }

    public int move(PositionManager positionManager) {
        this.state = positionManager.checkDirection(this.row, this.col, this.state);
        if(state == 0){
            gotoDown();
        }
        followLine();
        return this.col;
    }

    private void gotoDown() {
        this.row = this.row + 1;
    }

    private void followLine() {
        this.col = this.col + this.state;
    }

    public boolean isRowExceedValue(int value) {
        if(this.row > value)
            return false;
        return true;            
    }
}
