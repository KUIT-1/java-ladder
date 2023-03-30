package ladder;

public class Point {
    Position row;
    Position col;

    private Point(Position row, Position col) {
        this.row = row;
        this.col = col;
    }

    public static Point createPoint(Position row, Position col) {
        return new Point(row, col);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("row : " + row.getPosition());
        sb.append(",col : " + col.getPosition());
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Point))
            return false;
        Point point = (Point) o;
        return point.row.equals(row) && point.col.equals(col);
    }
}
