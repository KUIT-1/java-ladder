package ladder.domain.wrapper;

import java.awt.*;
import java.util.Objects;

public class Position {

    private final Point leftPoint;
    private final Point rightPoint;

    private Position(Point leftPoint, Point rightPoint) {
        this.leftPoint = leftPoint;
        this.rightPoint = rightPoint;
    }

    public static Position of(int x, int leftY, int rightY) {
        return new Position(new Point(x, leftY), new Point(x, rightY));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return Objects.equals(leftPoint, position.leftPoint) || Objects.equals(rightPoint, position.rightPoint)
                || Objects.equals(rightPoint, position.leftPoint) || Objects.equals(leftPoint, position.rightPoint);

    }

    @Override
    public int hashCode() {
        return 1;
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
