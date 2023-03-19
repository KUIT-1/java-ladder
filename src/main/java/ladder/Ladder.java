package ladder;

public class Ladder {

    private final int[][] rows;

    public Ladder(int numberOfPerson, int row) {
        rows = new int[numberOfPerson][row];
    }

    public void drawLine(Position position) {
        rows[position.getLeftPointXInt()][position.getLeftPointYInt()] = 1;
        rows[position.getRightPointXInt()][position.getRightPointYInt()] = -1;
    }

    public int getNumberOfPerson() {
        return rows[0].length;
    }

    public int getRow() {
        return rows.length;
    }

}
