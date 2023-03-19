package ladder;

import java.awt.*;

public class Position {

    private Point leftPoint;
    private Point rightPoint;

    public Position(Point leftPoint, Point rightPoint) {
        /** 두 좌표의 X 값 차가 1이어야 함 */
        if (Math.abs(leftPoint.getX() - rightPoint.getX()) != 1) throw new IllegalArgumentException();
        /** 두 좌표의 Y 값이 같아야 함 */
        if (leftPoint.getY() != rightPoint.getY()) throw new IllegalArgumentException();

        this.leftPoint = leftPoint;
        this.rightPoint = rightPoint;
    }

    public Point getLeftPoint() {
        return leftPoint;
    }

    public Point getRightPoint() {
        return rightPoint;
    }
}
