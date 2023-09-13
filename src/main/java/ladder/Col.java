package ladder;

// 열 class
// 사다리에서 세로줄 담당(사다리)
public class Col {

    // 옮겨갈 방향을 저장하는 변수
    private Direction[] col;
    //* 생성자
    public Col(PositiveNum col) {
        //마지막에 종료 위치 포함
        this.col = new Direction[col.getNum()];
    }

    //* 옮겨갈 위치 저장 함수(save)
    //current : 현재 사다리의 어느 위치인지?
    public void drawLine(PositiveNum current, Direction direction) {
        Position currentPos = new Position(current, new PositiveNum(col.length));
        col[currentPos.getPosition()] = direction;
    }



    //* 현 위치에서 어느 열로 가는지 반환 함수(return)
    public int checkDirection(PositiveNum current) {
        Position currentPos = new Position(current, new PositiveNum(col.length));
        //null인 경우 방향 전환이 없다는 의미. 0을 반환해 그 사다리를 계속 타고 내려감
        return col[currentPos.getPosition()]==null?Direction.DOWN.getNum():col[currentPos.getPosition()].getNum();
    }


}
