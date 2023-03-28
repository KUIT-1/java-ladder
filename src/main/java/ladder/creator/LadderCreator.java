package ladder.creator;

import ladder.Col;
import ladder.Direction;

public interface LadderCreator {

    
    boolean drawLine(int row, int col, Direction direction);
    Col[] getCols();

    //* 실질적으로 연결하는 함수
    default boolean connect(Col[] cols, int row, int col, Direction direction) {
        //fromCol : line을 그을 Col
        //toCol : line이 그어질 Col
        //방향에 맞춰 양방향으로 다닐 수 있게 연결
        Col fromCol = cols[col];
        Col toCol = cols[col + direction.getNum()];

        if(!fromCol.validLine(row)) return false;
        if(!toCol.validLine(row)) return false;

        fromCol.drawLine(row, direction);
        toCol.drawLine(row, direction.opposite());

        return true;
    }

}
