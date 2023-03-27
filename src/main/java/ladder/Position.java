package ladder;

public class Position {
    private int position;

    private Position(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void minusPosition(){
        position -= 1;

    }

    public void plusPosition(){
        position += 1;

    }

    public static Position createPosition(int position) {
        validatePosition(position);
        return new Position(position);
    }

    public boolean isSmaller(int position) {
        return this.position < position;
    }

    private static void validatePosition(int number) {
        if (!isPosition(number)) {
            throw new IllegalArgumentException("올바른 위치가 아닙니다.");
        }
    }

    private static boolean isPosition(int number) {
        return number > 0;
    }

}
