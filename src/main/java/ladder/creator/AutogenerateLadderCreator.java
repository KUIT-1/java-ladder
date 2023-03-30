package ladder.creator;

import ladder.LineByRow;
import ladder.NaturalNumber;
import ladder.Position;
import ladder.random.LadderSize;
import ladder.random.RanomCreatorManager;

import static ladder.Position.createPosition;
import static ladder.random.Point.createPoint;

public class RandomCreator implements LadderCreatorInterface{

    private LineByRow[] lineByRows;
    private LadderSize ladderSize;
    private RanomCreatorManager ranomCreatorManager;

    public RandomCreator(LadderSize ladderSize) {
        this.ladderSize = ladderSize;
        lineByRows = new LineByRow[ladderSize.getHeight().getNumber() + 1];
        initLineByRow(ladderSize.getHeight(), ladderSize.getNumberOfPerson());
        autoLadderCreator();
    }

    private void autoLadderCreator(){
        ranomCreatorManager = new RanomCreatorManager(ladderSize);
        NaturalNumber height = ladderSize.getHeight();
        NaturalNumber numberOfPerson = ladderSize.getNumberOfPerson();
        long lineSize = Math.round(height.getNumber() * numberOfPerson.getNumber() * 0.3);

        for(int lineNum = 0; lineNum < lineSize; lineNum++){
            lineNum = drawRandomLine(lineNum);

        }
    }

    private int drawRandomLine(int lineNum){
        NaturalNumber height = ladderSize.getHeight();
        NaturalNumber numberOfPerson = ladderSize.getNumberOfPerson();
        Position row = createPosition(randomByMax(height.getNumber()-2));
        Position col = createPosition(randomByMax(numberOfPerson.getNumber()-1));

        boolean flag = drawLine(row, col);
        if(flag){
            ranomCreatorManager.addPoint(createPoint(row, col));
            return lineNum;
        }
        return lineNum - 1;
    }

    private int randomByMax(int max){
        return (int) Math.random()*(max) + 1;
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
        if (col.getPosition() >= ladderSize.getNumberOfPerson().getNumber())
            return false;
        // throw new IllegalArgumentException("col 값이 유효하지 않습니다.");

        if (row.getPosition() > ladderSize.getHeight().getNumber())
            return false;
        // throw new IllegalArgumentException("row 값이 유효하지 않습니다.");

        if(ranomCreatorManager.has(createPoint(row, col)))
            return false;

        return true;
    }

    private void initLineByRow(NaturalNumber height, NaturalNumber numberOfPerson) {
        for(int row = 1; row < height.getNumber() + 1; row++){
            lineByRows[row] = new LineByRow(numberOfPerson);
        }
    }

    @Override
    public LineByRow[] getLineByRows() {
        return lineByRows;
    }
}
