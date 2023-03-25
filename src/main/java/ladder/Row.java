package ladder;

import static ladder.Direction.*;

public class Row {

    private int[] row;

    public Row(int numberOfPerson) {
        this.row = new int[numberOfPerson];
    }

    public int getValue(int y) {
        return row[y];
    }

    public void setValue(int leftY, int rightY) {
        row[leftY] = LEFT.getDirection();
        row[rightY] = RIGHT.getDirection();
    }

    public int nextPosition(int ladderNum) {
        switch (row[ladderNum]) {
            case 1 : return ++ladderNum;
            case -1 : return --ladderNum;
        }
        return ladderNum;
    }


    public int getLength() {
        return row.length;
    }
}
