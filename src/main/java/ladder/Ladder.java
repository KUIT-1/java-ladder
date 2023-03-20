package ladder;

public class Ladder {
    private final Row[] rows;


    public Ladder(int row, int numberOfPerson) {
        /* 싱글톤으로 만들었다가 테스트에 어려움을 느껴서 다시 원상복구
           row : 사다리의 높이
           numberOfPerson : 사다리 줄의 개수
         */
        rows = new Row[row];
        for (int i = 0; i < row; i++) {
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
