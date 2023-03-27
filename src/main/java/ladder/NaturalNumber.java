package ladder;

public class NaturalNumber {
    private final int number;

    private NaturalNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public static NaturalNumber createNaturalNumber(int number) {
        validateNumber(number);
        return new NaturalNumber(number);
    }

    private static void validateNumber(int number) {
        if (!isNaturalNumber(number)) {
            throw new IllegalArgumentException("자연수는 1이상이어야 합니다. 사다리를 생성할 수 없습니다.");
        }
    }

    private static boolean isNaturalNumber(int number) {
        return number > 0;

    }
}
