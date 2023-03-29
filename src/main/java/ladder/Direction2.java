package ladder;

public enum Direction2 {
    LEFT(1),RIGHT(-1),CENTER(0);
    int direction;

    Direction2(int direction) {
        this.direction=direction;
    }

    public int getDirection() {
        return direction;
    }
}
