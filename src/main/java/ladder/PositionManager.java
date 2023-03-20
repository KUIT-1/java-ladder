package ladder;

public class PositionManager {

    private Position[][] positions;
    private final int height;
    private final int numberOfPerson;

    public PositionManager(int height, int numberOfPerson) {
        positions = new Position[height + 1][numberOfPerson + 1];
        this.height = height;
        this.numberOfPerson = numberOfPerson;
        initPositions();
    }

    private void initPositions() {
        for(int row = 1; row < height + 1; row++){
            initCol(row);
        }
    }

    private void initCol(int row) {
        for(int col = 1; col < numberOfPerson + 1; col++){
            positions[row][col] = new Position();
        }
    }

    public void drawLine(int row, int col) {
        validateLine(row, col);
        positions[row][col].addLinetoRight();
        positions[row][col+1].addLinetoLeft();
    }

    private void validateLine(int row, int col) {
        // Line은 해당 지점에서 오른쪽으로 뻗는 line만 생성 가능
        if (col >= numberOfPerson || col < 1)
            throw new IllegalArgumentException("col 값이 유효하지 않습니다.");
        if (row > height || row < 1)
            throw new IllegalArgumentException("row 값이 유효하지 않습니다.");
    }

    public boolean isRowExceedHeight(Node node) {
        return node.isRowExceedValue(height);
    }

    public int checkDirection(int row, int col, int state) {
        return positions[row][col].checkDirection(state);
    }

    public void validateStartPoint(int startPoint) {
        if(startPoint < 1 || startPoint > numberOfPerson)
            throw new IllegalArgumentException("시작점의 값이 유효하지 않습니다.");
    }

}
