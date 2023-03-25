package ladder;

public class LadderNumber {

    private int number;

    private LadderNumber(int number) {
        this.number = number;
    }

    public static LadderNumber createLadderNumber(int number) {
        validateNumber(number);
        return new LadderNumber(number);
    }

    private static void validateNumber(int number) {
        if (!isPositiveNumber(number)) {
            throw new IllegalArgumentException("0 이상이어야 합니다.");
        }
    }

    private static boolean isPositiveNumber(int number) {
        return number > 0;
    }

    public void goRight() {
        number++;
    }

    public void goLeft() {
        number--;
    }

    public boolean isSmaller(int number) {
        return this.number < number;
    }

    public boolean isBigger(int number) {
        return this.number > number;
    }

    public boolean isEqual(int number) {
        return this.number == number;
    }

    public int getNumber() {
        return number;
    }
}
