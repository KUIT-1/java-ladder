package ladder;

public class Row {

    int[] row;

    public Row(int numberOfPerson) {
        validateNumberOfPerson(numberOfPerson);
        row = new int[numberOfPerson];
    }

    public void drawLine(int startPosition) {
        validateDrawLinePosition(startPosition);
        row[startPosition] = 1;
        row[startPosition + 1] = -1;
    }

    public int nextPosition(int position) {
        validatePosition(position);

        if (isNoLine(position)) {
            return position;
        }
        if (isLeft(position)) {
            return position - 1;
        }
        return position + 1;
    }

    private boolean isLeft(int position) {
        return row[position] == -1;
    }

    private boolean isNoLine(int position) {
        return row[position] == 0;
    }

    private void validateNumberOfPerson(int numberOfPerson) {
        if (numberOfPerson < 1) {
            throw new IllegalArgumentException();
        }
    }

    private void validatePosition(int position) {
        if (position >= row.length || position < 0) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDrawLinePosition(int startPosition) {
        if (startPosition >= row.length - 1 || startPosition < 0 || row[startPosition] == -1 || row[startPosition + 1] == 1) {
            throw new IllegalArgumentException();
        }
    }
}