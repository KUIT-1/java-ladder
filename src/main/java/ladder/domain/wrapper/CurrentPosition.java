package ladder.domain.wrapper;

import java.awt.*;

public class CurrentPosition {

    Point point;

    private CurrentPosition(LadderNumber ladderNum) {
        point = new Point(0, ladderNum.getNumber());
    }

    public static CurrentPosition createCurrentPosition(LadderNumber ladderNum) {
        return new CurrentPosition(ladderNum);
    }

    public boolean isYBiggerThan(int num) {
        return point.y > num;
    }

    public int getY() {
        return point.y;
    }

    public void goRight() {
        point.y++;
    }

    public void goLeft() {
        point.y--;
    }

    public void setX(int x) {
        point.setLocation(x, point.y);
    }

    public boolean equal(int x, int y) {
        return x == point.x && y == point.y;
    }
}
