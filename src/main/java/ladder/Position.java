package ladder;

public class Position {

    private int position;

    private Position(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public int getNextPosition() {
        return position + 1;
    }

    public void plus() {
        position += 1;
    }

    public void minus() {
        position -= 1;
    }

    public boolean isSmaller(int position) {
        return this.position < position;
    }

    public static Position createPosition(int position) {
        validatePosition(position);
        return new Position(position);
    }

    private static void validatePosition(int position) {
        if (position <= 0) {
            throw new IllegalArgumentException("position 값은 1 이상이어야 합니다.");
        }
    }
}
