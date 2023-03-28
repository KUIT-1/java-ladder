package ladder.creator;

import ladder.*;

import static ladder.Position.createPosition;
import static ladder.PositiveNum.createPositiveNumber;

public class LadderNormalCreator implements LadderCreator{


    private final Col[] cols;
    //* 생성자 - 초기화
    private LadderNormalCreator(LadderSize ladderSize) {

        cols = new Col[ladderSize.getNumberOfPerson()];
        for(int i = 0; i < cols.length; i++) {
            cols[i] = new Col(createPositiveNumber(ladderSize.getLadderLength()));
        }
    }

    public static LadderNormalCreator createLadderNormalCreator(LadderSize ladderSize) {
        return new LadderNormalCreator(ladderSize);
    }

    //* 선 긋는 함수

    //row : 선 그을 시작 위치(length)
    //col : 선 그을 시작 사다리
    //direction : 방향(좌측인지 우측인지)
    //좌측 : -1, 우측 : 1

    //정상작동 시 true, 오작동 시 false return
    public boolean drawLine(int row, int col, Direction direction) {
        Position positionCol = createPosition(col, cols.length);
        if(!positionCol.detectWall(direction)) return connect(cols, row, col, direction);
        return false;
    }




    public Col[] getCols() {
        return cols;
    }
}
