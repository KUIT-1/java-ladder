package ladder;

public class Ladder {
    private static Ladder ladder = null; // Singleton pattern
    private final Row[] rows;


    private Ladder(int row, int numberOfPerson) {
        /**
         *  row : 사다리의 높이
         *  numberOfPerson : 사다리 줄의 개수
         */
        rows = new Row[row];
        for (int i = 0; i < row; i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }

    public static Ladder getInstance(int row, int numberOfPerson) {
        if (ladder == null) {
            ladder = new Ladder(row, numberOfPerson);
        }
        return ladder;
    }

    public void drawLine(int row, int col) {
        // (col, row) 위치에 라인을 만듦
        rows[row].drawLine(col);
    }

    public int run(int startPosition) {
        // ladderStartNum 을 선택한 경우에 ladderEdnNum 에 도달한다
        int nextPosition = startPosition;
        for (int i = 0; i < rows.length; i++) {
            nextPosition = rows[i].getNextPosition(nextPosition);
        }
        return nextPosition;
    }
}
