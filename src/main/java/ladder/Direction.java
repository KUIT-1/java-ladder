package ladder;

public enum Direction {
    isLadder(1), noLadder(0);

    private final int direction;

    Direction(int direction) {
        this.direction = direction;
    }

    public int getDirection() {
        return direction;
    }
}
