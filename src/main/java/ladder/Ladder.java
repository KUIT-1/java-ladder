package ladder;

public class Ladder {

    private final Row[] rows;

    public Ladder(NumberOfRow row, NumberOfPerson numberOfPerson) {
        rows = new Row[row.getNumberOfRow()];
        for (int i = 0; i < row.getNumberOfRow(); i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }

    public void drawLine(int x, int leftY, int rightY) {
        rows[x].setValue(leftY, rightY);
    }

    public int run(LadderNumber ladderNum) {
        for (Row row : rows) {
            row.nextPosition(ladderNum);
        }

        return ladderNum.getNumber();
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
