package ladder.domain.wrapper;

import ladder.domain.creator.LadderCreator;

import java.awt.*;

public class Position {

    private Point leftPoint;
    private Point rightPoint;

    public Position(Point leftPoint, Point rightPoint, LadderCreator ladderCreator) {
        validatePoint(leftPoint, rightPoint, ladderCreator);

        this.leftPoint = leftPoint;
        this.rightPoint = rightPoint;
    }

    private static void validatePoint(Point leftPoint, Point rightPoint, LadderCreator ladderCreator) {
        /** Y 좌표값이 numberOfPerson을 넘어선 안됨 */
        if (leftPoint.getY()  > ladderCreator.getRows()[0].getLength()) throw new IllegalArgumentException();
        if (rightPoint.getY() > ladderCreator.getRows()[0].getLength()) throw new IllegalArgumentException();
        /** X 좌표값이 row을 넘어선 안됨
         *  또한 마지막 row와 같아서도 안됨 */
        if (leftPoint.getX() > ladderCreator.getRows().length -1) throw new IllegalArgumentException();
        if (rightPoint.getX() > ladderCreator.getRows().length -1) throw new IllegalArgumentException();

        /** rightPoint.Y > leftPoint.Y*/
        if (rightPoint.getY() <= leftPoint.getY()) throw new IllegalArgumentException();
        /** 두 좌표의 Y 값 차가 1이어야 함 */
        if (leftPoint.getY() - rightPoint.getY() != -1) throw new IllegalArgumentException();

        /** 해당 좌표에 값이 있으면 안 됨 (선이 그어져 있으면 안됨) */
        if (ladderCreator.getRows()[leftPoint.x].getValue(leftPoint.y) != 0) throw new IllegalArgumentException();
        if (ladderCreator.getRows()[rightPoint.x].getValue(rightPoint.y) != 0) throw new IllegalArgumentException();
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
