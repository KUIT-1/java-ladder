package ladder.random;

import ladder.NaturalNumber;
import ladder.Position;

public class Point{

    private Position row;
    private Position col;

    private Point(Position row, Position col){
        this.row = row;
        this.col = col;
    }
    public static Point createPoint(Position row, Position col){
        return new Point(row, col);
    }

    public int getRow(){
        return row.getPosition();
    }

    public int getCol(){
        return col.getPosition();
    }

    private boolean IsSamePoint(Point other){
        if(getRow() == other.getRow()
                && getCol() == other.getCol())
            return true;
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Point){
            Point other = (Point) o;
            return IsSamePoint(other);
        }
        return false;
    }
    @Override
    public int hashCode() {
        return getRow() * getCol();
    }

}