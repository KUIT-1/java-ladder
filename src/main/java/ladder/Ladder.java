package ladder;

public class Ladder {

    private final Row[] rows;

    public Ladder(int row, int numberOfPerson) {
        validateParameters(row, numberOfPerson);

        rows = new Row[row];
        for (int i = 0; i < row; i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }

    private static void validateParameters(int row, int numberOfPerson) {
        if (row < 3) throw new IllegalArgumentException();
        if (numberOfPerson < 2) throw new IllegalArgumentException();
    }

    public void drawLine(int x, int leftY, int rightY) {
        rows[x].setValue(leftY, rightY);
    }

    public int run(int ladderNum) {
        int row = 0;
        while (row + 1 < rows.length) {
            ladderNum = rows[row++].nextPosition(ladderNum);
        }

        return ladderNum;
    }

    public int getNumberOfPerson() {
        return rows[0].getLength();
    }

    public int getRow() {
        return rows.length;
    }

    public Row[] getRowsForTest() {
        return rows;
    }

}
