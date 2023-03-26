package ladder;

public class LineManager {

    private LineByRow[] lineByRows;
    private final NaturalNumber height;
    private final NaturalNumber numberOfPerson;

    public LineManager(NaturalNumber height, NaturalNumber numberOfPerson) {
        lineByRows = new LineByRow[height.getNumber() + 1];
        this.height = height;
        this.numberOfPerson = numberOfPerson;
        initLineByRow(height, numberOfPerson);
    }

    private void initLineByRow(NaturalNumber height, NaturalNumber numberOfPerson) {
        for(int row = 1; row < height.getNumber() + 1; row++){
            lineByRows[row] = new LineByRow(numberOfPerson);
        }
    }

    public void drawLine(Position row, Position col) {
        validateLine(row, col);
        lineByRows[row.getPosition()].addLinetoRight(col);
        lineByRows[row.getPosition()].addLinetoLeft(col.nextPosition());
    }

    public boolean isRowExceedHeight(Node node) {

        return node.isRowExceedValue(height);
    }


    public Direction nextDirection(Position row, Position col, Direction state) {
        return lineByRows[row.getPosition()].nextDirection(col, state);
    }

    private void validateLine(Position row, Position col) {
        // Line은 해당 지점에서 오른쪽으로 뻗는 line만 생성 가능
        if (col.getPosition() >= numberOfPerson.getNumber())
            throw new IllegalArgumentException("col 값이 유효하지 않습니다.");
        if (row.getPosition() > height.getNumber())
            throw new IllegalArgumentException("row 값이 유효하지 않습니다.");
    }

    public void validateStartPoint(Position startPoint) {
        if(startPoint.getPosition() > numberOfPerson.getNumber())
            throw new IllegalArgumentException("시작점의 값이 유효하지 않습니다.");
    }

}
