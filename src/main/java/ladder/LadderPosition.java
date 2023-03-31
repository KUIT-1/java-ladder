package ladder;

public class LadderPosition {
    private final Position x;
    private final Position y;

    private LadderPosition(Position y, Position x) {
        this.x = x;
        this.y = y;
    }

    public static LadderPosition createLadderPosition(Position y, Position x){
        return new LadderPosition(y, x);
    }

    public Position getRowPosition(){
        return y;
    }

    public Position getColPosition(){
        return x;
    }

//    @Override
//    //public int hashCode() {
//        return x.getPosition()*y.getPosition();
//    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof LadderPosition){
            LadderPosition ladderPosition = (LadderPosition) obj;

            System.out.println(this.x.getPosition() + " " + ladderPosition.x.getPosition());

            return this.x.getPosition() == ladderPosition.x.getPosition() && this.y.getPosition() == ladderPosition.y.getPosition();
        }
        return false;
    }
}
