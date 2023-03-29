package ladder;

public class LadderPosition {
    Position x;
    Position y;

    public LadderPosition(Position x, Position y) {
        this.x = x;
        this.y = y;
    }

    public Position getX() {
        return x;
    }

    public Position getY() {
        return y;
    }

    public int getPositionX() {
        return x.getPosition();
    }

    public int getPositionY() {
        return y.getPosition();
    }

    @Override
    public boolean equals(Object o) {
        LadderPosition position = (LadderPosition) o;
        return (this.getPositionX() == position.getPositionX()) && (this.getPositionY() == position.getPositionY());
    }

    public static LadderPosition createLadderPosition(Position x, Position y) {
        return new LadderPosition(x, y);
    }
}
