package ladder;

public class LineManager {

    private LineByRow[] lineByRows;
    private final int height;
    private final int numberOfPerson;

    public LineManager(int height, int numberOfPerson) {
        lineByRows = new LineByRow[height + 1];
        this.height = height;
        this.numberOfPerson = numberOfPerson;
        initLineByRow(height, numberOfPerson);
    }

    private void initLineByRow(int height, int numberOfPerson) {
        for(int row = 1; row < height + 1; row++){
            lineByRows[row] = new LineByRow(numberOfPerson);
        }
    }

    public void drawLine(int row, int col) {
        validateLine(row, col);
        lineByRows[row].addLinetoRight(col);
        lineByRows[row].addLinetoLeft(col+1);
    }

    public boolean isRowExceedHeight(Node node) {

        return node.isRowExceedValue(height);
    }

    public int nextDirection(int row, int col, int state) {
        return lineByRows[row].nextDirection(col, state);
    }

    private void validateLine(int row, int col) {
        // Line은 해당 지점에서 오른쪽으로 뻗는 line만 생성 가능
        if (col >= numberOfPerson || col < 1)
            throw new IllegalArgumentException("col 값이 유효하지 않습니다.");
        if (row > height || row < 1)
            throw new IllegalArgumentException("row 값이 유효하지 않습니다.");
    }

    public void validateStartPoint(int startPoint) {
        if(startPoint < 1 || startPoint > numberOfPerson)
            throw new IllegalArgumentException("시작점의 값이 유효하지 않습니다.");
    }

}
