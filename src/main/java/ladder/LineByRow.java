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

    public void addLinetoRight(Position col) {
        lineByPositions[col.getPosition()].addLinetoRight();
    }

    public void addLinetoLeft(Position col) {
        lineByPositions[col.getPosition()].addLinetoLeft();
    }

    public int nextDirection(int col, int state) {
        return lineByPositions[col].nextDirection(state);
    }
}
