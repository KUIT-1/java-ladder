package ladder;

public class Position {

    private boolean left;
    private boolean right;

    public Position() {
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
        if(state == 0 && this.right){ // gotoRight
            return 1;
        }
        if(state == 0 && this.left){ // gotoLeft
            return -1;
        }
        if(state == 1 && this.right){ // gotoRight
            return 1;
        }
        if(state == -1 && this.left){ // gotoLeft
            return -1;
        }
        return 0;
    }
}
