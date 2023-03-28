package ladder;

import static ladder.Position.createPosition;

// 열 class
// 사다리에서 세로줄 담당(사다리)
public class Col {

    // 옮겨갈 방향을 저장하는 변수
    private Direction[] col;
    //* 생성자
    public Col(PositiveNum col) {
        this.col = new Direction[col.getNum()];
    }

    //* 옮겨갈 위치 저장 함수(save)
    //current : 현재 사다리의 어느 위치인지?
    public void drawLine(int current, Direction direction) {
        Position currentPos = createPosition(current,col.length);
        col[currentPos.getPosition()] = direction;
    }


    //* 옮겨갈 위치에 저장이 가능한지 판단하는 함수
    //사다리를 저장하기로 한 값이 DOWN이라면 저장 아니면 저장 X
    public boolean validLine(int current) {
        Position currentPos = createPosition(current, col.length);
        //Direction.Down이랑 null이랑 동일시
        if(col[currentPos.getPosition()] == Direction.DOWN) col[currentPos.getPosition()] = null;
        if(col[currentPos.getPosition()] == null) return true;
        return false;
    }



    //* 현 위치에서 어느 열로 가는지 반환 함수(return)
    public int checkDirection(int current) {
        Position currentPos = createPosition(current, col.length);
        //null인 경우 방향 전환이 없다는 의미. 0을 반환해 그 사다리를 계속 타고 내려감
        return col[currentPos.getPosition()]==null?Direction.DOWN.getNum():col[currentPos.getPosition()].getNum();
    }

    public int getColLength() {
        return col.length;
    }

    //출력 관련 함수
    public String toString(int i) {
            if(col[i] == null) return "┃ ";
            else if(col[i] == Direction.LEFT) return "┫ ";
            return "┣━";
    }


}
