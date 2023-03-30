package ladder.creator;

import ladder.lineinfo.LineByRow;
import ladder.NaturalNumber;
import ladder.Position;
import ladder.LadderSize;
import ladder.random.RandomCreatorManager;

import static ladder.Position.createPosition;
import static ladder.random.Point.createPoint;

public class AutogenerateLadderCreator implements LadderCreator {

    private LineByRow[] lineByRows;
    private LadderSize ladderSize;
    private RandomCreatorManager randomCreatorManager;

    // 상수
    // 뒤에서부터 접근 가능한 인덱스
    private static final int ACCESSIBLE_LAST_INDEX_FROM_NTHPERSON = 2;
    private static final int ACCESSIBLE_LAST_INDEX_FROM_HEIGHT = 1;
    private static final int START_INDEX = 1;

    public AutogenerateLadderCreator(LadderSize ladderSize) {
        this.ladderSize = ladderSize;

        lineByRows = new LineByRow[ladderSize.getHeight() + START_INDEX];
        initLineByRow(ladderSize.getHeight(), ladderSize.getNumberOfPerson());
        autoLadderCreator();
    }

    private void autoLadderCreator(){
        randomCreatorManager = new RandomCreatorManager(ladderSize);
        long lineSize = Math.round(ladderSize.getHeight() * ladderSize.getNumberOfPerson() * 0.3);

        for(int lineNum = 0; lineNum < lineSize; lineNum++){
            lineNum = drawRandomLine(lineNum);
        }
    }

    private int drawRandomLine(int lineNum){
        Position row = createPosition(randomByMax(ladderSize.getHeight() - ACCESSIBLE_LAST_INDEX_FROM_HEIGHT));
        Position col = createPosition(randomByMax(ladderSize.getNumberOfPerson() - ACCESSIBLE_LAST_INDEX_FROM_NTHPERSON));

        boolean flag = drawLine(row, col);
        if(flag){
            randomCreatorManager.addPoint(createPoint(row, col));
            return lineNum;
        }
        return --lineNum;
    }

    private int randomByMax(int max){
        return (int) (Math.random() * max + START_INDEX);
    }
    @Override
    public boolean drawLine(Position row, Position col) {
        boolean flag = validateLine(row, col);
        if(!flag) return flag;
        lineByRows[row.getPosition()].addLinetoRight(col);
        lineByRows[row.getPosition()].addLinetoLeft(col.nextPosition());
        return flag;
    }

    @Override
    public boolean validateLine(Position row, Position col) {
        // Line은 해당 지점에서 오른쪽으로 뻗는 line만 생성 가능
        if (col.getPosition() >= ladderSize.getNumberOfPerson())
            return false;

        if (row.getPosition() > ladderSize.getHeight())
            return false;

        if(randomCreatorManager.has(createPoint(row, col)))
            return false;

        return true;
    }

    private void initLineByRow(int height, int numberOfPerson) {
        for(int row = START_INDEX; row <= height; row++){
            lineByRows[row] = new LineByRow(NaturalNumber.createNaturalNumber(numberOfPerson));
        }
    }

    @Override
    public LineByRow[] getLineByRows() {
        return lineByRows;
    }
}
