package ladder.domain.wrapper;

import java.awt.*;
import java.util.Objects;

public class Rung {

    private final Point leftPoint;
    private final Point rightPoint;

    private Rung(Point leftPoint, Point rightPoint) {
        this.leftPoint = leftPoint;
        this.rightPoint = rightPoint;
    }

    public static Rung of(int x, int leftY, int rightY) {
        return new Rung(new Point(x, leftY), new Point(x, rightY));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rung rung = (Rung) o;
        return Objects.equals(leftPoint, rung.leftPoint) || Objects.equals(rightPoint, rung.rightPoint)
                || Objects.equals(rightPoint, rung.leftPoint) || Objects.equals(leftPoint, rung.rightPoint);

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
