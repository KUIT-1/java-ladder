package ladder;

public class Ladder {
    private final Row[] rows;

    public Ladder(NaturalNumber row, NaturalNumber numberOfPerson) {
        /*
           row : 사다리의 높이
           numberOfPerson : 사다리 줄의 개수
         */
        rows = new Row[row.getNumber()];
        for (int i = 0; i < row.getNumber(); i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }
    public void drawLine(int row, int col) {
        // (col, row) 위치에 라인을 만듦
        rows[row].drawLine(col);
    }

    public int run(int startPosition) {
        // ladderStartNum 을 선택한 경우에 ladderEdnNum 에 도달한다
        int nextPosition = startPosition;
        for (Row row : rows) {
            nextPosition = row.getNextPosition(nextPosition);
        }
        return nextPosition;
    }
}
