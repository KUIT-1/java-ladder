package ladder.creator;

import ladder.LineByRow;
import ladder.NaturalNumber;
import ladder.Position;
import ladder.random.LadderSize;

public class LadderCreatorNew implements LadderCreator {

    private LineByRow[] lineByRows;
    private LadderSize ladderSize;

    public LadderCreatorNew(LadderSize ladderSize) {
        this.ladderSize = ladderSize;
        NaturalNumber height = ladderSize.getHeight();
        NaturalNumber numberOfPerson = ladderSize.getNumberOfPerson();

        this.lineByRows = new LineByRow[height.getNumber() + 1];
        initLineByRow(height, numberOfPerson);
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
        NaturalNumber numberOfPerson = ladderSize.getNumberOfPerson();
        NaturalNumber height = ladderSize.getHeight();

        // Line은 해당 지점에서 오른쪽으로 뻗는 line만 생성 가능
        if (col.getPosition() >= numberOfPerson.getNumber())
            throw new IllegalArgumentException("col 값이 유효하지 않습니다.");

        if (row.getPosition() > height.getNumber())
            throw new IllegalArgumentException("row 값이 유효하지 않습니다.");

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
