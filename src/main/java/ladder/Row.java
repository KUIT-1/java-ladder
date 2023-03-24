package ladder;

public class Row {

    private int[] row;

    public Row(int numberOfPerson) {
        this.row = new int[numberOfPerson];
    }

    public int getValue(int y) {
        return row[y];
    }

    public void setValue(int leftY, int rightY) {
        row[leftY] = 1;
        row[rightY] = -1;
    }

    public int nextPosition(int ladderNum) {
        switch (row[ladderNum]) {
            case 1 : ladderNum++; break;
            case -1: ladderNum--; break;
            case 0: break;
        }
        return ladderNum;
    }


    public int getLength() {
        return row.length;
    }
}
