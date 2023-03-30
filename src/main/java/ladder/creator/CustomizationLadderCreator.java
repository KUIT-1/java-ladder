package ladder.creator;

import ladder.lineinfo.LineByRow;
import ladder.NaturalNumber;
import ladder.Position;
import ladder.LadderSize;

public class CustomizationLadderCreator implements LadderCreator {

    private LineByRow[] lineByRows;
    private LadderSize ladderSize;
    private static final int START_INDEX = 1;

    public CustomizationLadderCreator(LadderSize ladderSize) {
        this.ladderSize = ladderSize;

        this.lineByRows = new LineByRow[ladderSize.getHeight() + START_INDEX];
        initLineByRow(ladderSize.getHeight(), ladderSize.getNumberOfPerson());
    }

    @Override
    public boolean drawLine(Position row, Position col) {
        validateLine(row, col);
        lineByRows[row.getPosition()].addLinetoRight(col);
        lineByRows[row.getPosition()].addLinetoLeft(col.nextPosition());
        return true;
    }

    @Override
    public boolean validateLine(Position row, Position col) {
        // Line은 해당 지점에서 오른쪽으로 뻗는 line만 생성 가능
        if (col.getPosition() >= ladderSize.getNumberOfPerson())
            throw new IllegalArgumentException("col 값이 유효하지 않습니다.");

        if (row.getPosition() > ladderSize.getHeight())
            throw new IllegalArgumentException("row 값이 유효하지 않습니다.");

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
