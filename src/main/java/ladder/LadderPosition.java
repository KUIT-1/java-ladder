package ladder;

public class LadderPosition {
    private Position x;
    private int y;

    private LadderPosition(Position x, int y) {
        setLocation(x,y);
    }

    public static LadderPosition createLadderPosition(Position x, int y){
        return new LadderPosition(x,y);
    }

    public Position getX() {
        return x;
    }

    public void setLocation(Position x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean checkCurrentRow(int currentRow) {
        return y==currentRow;
    }
}
