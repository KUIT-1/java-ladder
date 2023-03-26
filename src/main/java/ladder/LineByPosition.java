package ladder;

import static ladder.Direction.*;

public class LineByPosition {

    private boolean left;
    private boolean right;

    public LineByPosition() {
        this.left = false;
        this.right = false;
    }

    public void addLinetoLeft(){
        this.left = true;
    }

    public void addLinetoRight(){
        this.right = true;
    }

    public int nextDirection(int state) {
        if(state == DOWN.getDirection() && this.right){ // gotoRight
            return RIGHT.getDirection();
        }
        if(state == DOWN.getDirection() && this.left){ // gotoLeft
            return LEFT.getDirection();
        }
        if(state == RIGHT.getDirection() && this.right){ // gotoRight
            return RIGHT.getDirection();
        }
        if(state == LEFT.getDirection() && this.left){ // gotoLeft
            return LEFT.getDirection();
        }
        return DOWN.getDirection();
    }
}
