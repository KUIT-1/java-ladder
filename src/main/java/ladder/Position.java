package ladder;

public class Position {
    Point x;
    Point y;
    // pointX의 범위

    public Position(int pointX, int pointY) {
        this.x = new Point(pointX);
        this.y = new Point(pointY);
    }

    public int getX() {
        return x.getValue();
    }

    public int getY() {
        return y.getValue();
    }
}
