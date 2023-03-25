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

        if (isLeft(ladderNum.getNumber())) {
            ladderNum.goRight();
            return;
        }
        if (isRight(ladderNum.getNumber())) {
            ladderNum.goLeft();
            return;
        }
    }

    private void validateLadderNumber(LadderNumber ladderNum) {
        if (ladderNum.isBigger(row.length)) throw new IllegalArgumentException();
    }

    private boolean isLeft(int ladderNumber) {
        return row[ladderNumber] == LEFT.getDirection();
    }

    private boolean isRight(int ladderNumber) {
        return row[ladderNumber] == RIGHT.getDirection();
    }

    public int getLength() {
        return row.length;
    }
}
