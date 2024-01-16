package ladder.domain.wrapper;

public class LadderNumber {

    private int number;

    private LadderNumber(int number) {
        this.number = number;
    }

    public static LadderNumber of(int number) {
        validateNumber(number);
        return new LadderNumber(number);
    }

    private static void validateNumber(int number) {
        if (!isNaturalNumber(number)) {
            throw new IllegalArgumentException("0 이상이어야 합니다.");
        }
    }

    private static boolean isNaturalNumber(int number) {
        return number >= 0;
    }

    public int getNumber() {
        return number;
    }
}
