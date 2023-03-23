package ladder;

public class LineByRow {
    private LineByPosition[] lineByPositions;

    public LineByRow(int numberOfPerson) {
        lineByPositions = new LineByPosition[numberOfPerson + 1];
        initLineByPosition(numberOfPerson);
    }

    private void initLineByPosition(int numberOfPerson) {
        for(int col = 1; col < numberOfPerson + 1; col++){
            lineByPositions[col] = new LineByPosition();
        }
    }

    public void addLinetoRight(int col) {
        lineByPositions[col].addLinetoRight();
    }

    public void addLinetoLeft(int col) {
        lineByPositions[col].addLinetoLeft();
    }

    public int nextDirection(int col, int state) {
        return lineByPositions[col].nextDirection(state);
    }
}
