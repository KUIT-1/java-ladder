package ladder;

public class Position {
    private final int row;
    private final int position;

    public Position(int row, int position) {
        this.row = row;
        this.position = position;
    }

    public int getRow() {
        return row;
    }

    public int getPosition() {
        return position;
    }
}
