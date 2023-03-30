package ladder.lineinfo;

import ladder.Direction;

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

    public Direction nextDirection(Direction state) {
        if(state == DOWN && this.right){ // gotoRight
            return RIGHT;
        }
        if(state == DOWN && this.left){ // gotoLeft
            return LEFT;
        }
        if(state == RIGHT && this.right){ // gotoRight
            return RIGHT;
        }
        if(state == LEFT && this.left){ // gotoLeft
            return LEFT;
        }
        return DOWN;
    }

    public String infoLine() {
        if(left && right)
            return "↔";
        if(left)
            return "←";
        if(right)
            return "→";
        return "0";
    }

}
