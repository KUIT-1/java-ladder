package ladder;

import java.awt.*;

public class Position {

    private Point leftPoint;
    private Point rightPoint;

    public Position(Point leftPoint, Point rightPoint, Ladder ladder) {
        validatePoint(leftPoint, rightPoint, ladder);

        this.leftPoint = leftPoint;
        this.rightPoint = rightPoint;
    }

    private static void validatePoint(Point leftPoint, Point rightPoint, Ladder ladder) {
        /** Y 좌표값이 numberOfPerson을 넘어선 안됨 */
        if (leftPoint.getY()  > ladder.getNumberOfPerson()) throw new IllegalArgumentException();
        if (rightPoint.getY() > ladder.getNumberOfPerson()) throw new IllegalArgumentException();
        /** X 좌표값이 row을 넘어선 안됨
         *  또한 마지막 row와 같아서도 안됨 */
        if (leftPoint.getX() > ladder.getRow() -1) throw new IllegalArgumentException();
        if (rightPoint.getX() > ladder.getRow() -1) throw new IllegalArgumentException();

        /** rightPoint.Y > leftPoint.Y*/
        if (rightPoint.getY() <= leftPoint.getY()) throw new IllegalArgumentException();
        /** 두 좌표의 Y 값 차가 1이어야 함 */
        if (leftPoint.getY() - rightPoint.getY() != -1) throw new IllegalArgumentException();
        /** 두 좌표의 X 값이 같아야 함 */
        if (leftPoint.getX() != rightPoint.getX()) throw new IllegalArgumentException();
    }

    public int getLeftPointXInt() {
        return (int) leftPoint.getX();
    }

    public int getRightPointXInt() {
        return (int) rightPoint.getX();
    }

    public int getLeftPointYInt() {
        return (int) leftPoint.getY();
    }

    public int getRightPointYInt() {
        return (int) rightPoint.getY();
    }
}
