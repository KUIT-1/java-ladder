package ladder;

public class Ladder {

    private final int[][] rows;

    public Ladder(int row, int numberOfPerson) {
        validateParameters(row, numberOfPerson);

        rows = new int[row][numberOfPerson];
    }

    private static void validateParameters(int row, int numberOfPerson) {
        if (row < 3) throw new IllegalArgumentException();
        if (numberOfPerson < 2) throw new IllegalArgumentException();
    }

    public void drawLine(Position position) {
        rows[position.getLeftPointXInt()][position.getLeftPointYInt()] = 1;
        rows[position.getRightPointXInt()][position.getRightPointYInt()] = -1;
    }

    public int run(int ladderNum) {
        int row = 0;

        while (row + 1 < rows.length) {
            switch (rows[row][ladderNum]) {
                case 1: ladderNum++; row++; break;
                case -1: ladderNum--; row++; break;
                case 0: row++; break;
            }
        }

        return ladderNum;
    }

    public int getNumberOfPerson() {
        return rows[0].length;
    }

    public int getRow() {
        return rows.length;
    }

    public int[][] getRowsForTest() {
        return rows;
    }

}
