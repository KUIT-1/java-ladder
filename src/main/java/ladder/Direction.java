package ladder;

public enum Direction {
    LEFT(-1),
    RIGHT(1),
    STRAIGHT(0);

    private final int direction;
    Direction(int direction){
        this.direction = direction;
    }
    public int getFlag(){
        return this.direction;
    }
}
