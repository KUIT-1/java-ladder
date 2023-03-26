package ladder;

public enum Direction {
    LEFT(-1),
    DOWN(0),
    RIGHT(1);

    private int direction;

    Direction(int direction) {
        this.direction = direction;
    }

    public int getDirection() {
        return direction;
    }
}
