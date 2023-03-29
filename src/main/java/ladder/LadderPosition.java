package ladder;

import java.util.Objects;

public class LadderPosition {
    private Position x;
    private Position y;

    private LadderPosition(Position x, int y) {
        setLocation(x,y);
    }

    public static LadderPosition createLadderPosition(Position x,int y){
        return new LadderPosition(x,y);
    }

    public Position getX() {
        return x;
    }

    public int getXPosition(){
        return x.getPosition();
    }

    public Position getY() {
        return y;
    }

    public int getYPosition(){
        return y.getPosition();
    }


    public void setLocation(Position x, int y) {
        this.x = x;
        this.y = Position.createPosition(y);
    }

    public boolean checkCurrentRow(int currentRow) {
        return y.getPosition()==currentRow;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderPosition that = (LadderPosition) o;
        return Objects.equals(x.getPosition(), that.x.getPosition()) && Objects.equals(y.getPosition(), that.y.getPosition());
    }

    @Override
    public int hashCode() {
        return x.getPosition()*10+y.getPosition();
    }
}
