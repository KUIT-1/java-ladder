package ladder.creator;

import ladder.*;

import java.util.Random;
import static ladder.Position.createPosition;
import static ladder.PositiveNum.createPositiveNumber;

public class LadderRandomCreator implements LadderCreator{

    private final Col[] cols;
    private final int numberOfLine;
    public LadderRandomCreator(LadderSize ladderSize) {
        cols = new Col[ladderSize.getNumberOfPerson()];
        for(int i = 0; i < cols.length; i++) {
            cols[i] = new Col(createPositiveNumber(ladderSize.getLadderLength()));
        }
        numberOfLine = ladderSize.getNumberOfLine();
    }

    public static LadderRandomCreator createLadderRandomCreator(LadderSize ladderSize) {
        return new LadderRandomCreator(ladderSize);
    }

    //인터페이스 override
    // drawLine()함수를 정해진 수만큼 반복
    @Override
    public boolean drawLine(int row, int col, Direction direction) {
        for(int i = 0; i < numberOfLine; i++) i = drawLine()?i:i-1;
        return true;
    }

    //randomize하게 drawLine() overload
    //사다리가 그려지지 못하면 false 반환 -> false일시 다시 실행
    public boolean drawLine() {
        Random random = new Random();
        int row = random.nextInt(cols.length-1);
        int col = random.nextInt(cols[0].getColLength()-1);
        Position positionCol = createPosition(col, cols.length);
        Direction direction = random.nextInt(1)==0?Direction.LEFT:Direction.RIGHT;
        if(positionCol.detectWall(direction)) return false;
        connect(cols, row,col,direction);
        return true;
    }

    public Col[] getCols() {
        return cols;
    }
}
