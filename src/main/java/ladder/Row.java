package ladder;

public class Row {
    private final int numberOfPerson;
    private final boolean[] lineDrawn;

    public Row(int numberOfPerson) {
        validatePersonNum(numberOfPerson);
        this.numberOfPerson = numberOfPerson;
        this.lineDrawn = new boolean[numberOfPerson - 1];
    }

    public void drawLine(int startPosition) {
        validatePosition(startPosition);

        lineDrawn[startPosition - 1] = true;
    }

    public boolean isLineDrawn(int position) {
        validatePosition(position);

        return lineDrawn[position - 1];
    }

    public int getNumberOfPerson() {
        return numberOfPerson;
    }

    private void validatePosition(int position) {
        if (position < 1 || position >= numberOfPerson) {
            throw new IllegalArgumentException("Invalid position: " + position);
        }
    }
    private void validatePersonNum(int numberOfPerson){
        if(numberOfPerson<1){
            throw new IllegalArgumentException();
        }
    }
}
