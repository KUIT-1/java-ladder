package ladder;

//위치 무결성(사다리 안에 있는지)
//사다리 밖으로 나가면 에러 발생 아니면 PositiveNum(0 혹은 양수) 저장
//col, row 모두에게 적용

import static ladder.PositiveNum.createPositiveNumber;

public class Position {
    private PositiveNum position;
    private PositiveNum pNum;

    private Position(PositiveNum position, PositiveNum pNum) {
        this.position = position;
        this.pNum = pNum;
    }

    public static Position createPosition(int pos, int pNum) {
        PositiveNum pPos = createPositiveNumber(pos);
        PositiveNum posNum = createPositiveNumber(pNum);
        validPosition(pPos, posNum);
        return new Position(pPos, posNum);
    }

    //사다리 밖으로 나가게 되면 에러 발생
    public static void validPosition(PositiveNum pos, PositiveNum pNum) {
        if(pos.getNum() >= pNum.getNum()) throw new IllegalArgumentException("포지션 에러");
    }

    //* 사다리 끝을 감지하는 함수
    // 0보다 작은데 왼쪽으로 연결하려하거나, 제일 우측에서 사다리를 우측으로 연결하려하면 true 반환
    public boolean detectWall(Direction direction) {
        if((position.getNum() <= 0) && direction.equals(Direction.LEFT)) return true;
        if((position.getNum() >= pNum.getNum()-1) && direction.equals(Direction.RIGHT)) return true;
        return false;
    }
    public int getPosition() {return position.getNum();}
    public void addPosition(int num) {position.addNum(num);}
}
