package ladder;

//방향 enum class
public enum Direction {
    //방향 상수들
    LEFT(-1), RIGHT(1), DOWN(0);

    private int num;

    private Direction(int num) {
        this.num = num;
    }

    public int getNum() {return num;}

    //* 반대 방향을 반환하는 함수
    public Direction opposite() {
        if(this.num == LEFT.getNum()) return RIGHT;
        if(this.num == RIGHT.getNum()) return LEFT;
        return DOWN;
    }
}
