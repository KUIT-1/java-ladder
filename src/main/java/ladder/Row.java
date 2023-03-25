package ladder;

import static ladder.Direction.*;

public class Row {

    private int[] row;

    public Row(NumberOfPerson numberOfPerson) {
        this.row = new int[numberOfPerson.getNumberOfPerson()];
    }

    public int getValue(int y) {
        return row[y];
    }

    public void setValue(int leftY, int rightY) {
        row[leftY] = LEFT.getDirection();
        row[rightY] = RIGHT.getDirection();
    }

    public void nextPosition(LadderNumber ladderNum) {
        validateLadderNumber(ladderNum);

        switch (row[ladderNum.getNumber()]) {
            case 1 : ladderNum.goRight(); break;
            case -1 : ladderNum.goLeft(); break;
        }
    }

    private void validateLadderNumber(LadderNumber ladderNum) {
        if (ladderNum.isBigger(row.length)) throw new IllegalArgumentException();
    }


    public int getLength() {
        return row.length;
    }
}
