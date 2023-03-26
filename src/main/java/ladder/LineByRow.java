package ladder;

public class LineByRow {
    private LineByPosition[] lineByPositions;

    public LineByRow(NaturalNumber numberOfPerson) {
        lineByPositions = new LineByPosition[numberOfPerson.getNumber() + 1];
        initLineByPosition(numberOfPerson);
    }

    private void initLineByPosition(NaturalNumber numberOfPerson) {
        for(int col = 1; col < numberOfPerson.getNumber() + 1; col++){
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
