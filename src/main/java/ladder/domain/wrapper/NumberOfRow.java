package ladder.domain.wrapper;

public class NumberOfRow {

    private final int numberOfRow;

    private NumberOfRow(int numberOfPerson) {
        this.numberOfRow = numberOfPerson;
    }

    public static NumberOfRow of(int numberOfRow) {
        validateNumber(numberOfRow);
        return new NumberOfRow(numberOfRow);
    }

    private static void validateNumber(int numberOfRow) {
        if (!isNaturalNumber(numberOfRow)) {
            throw new IllegalArgumentException("row는 3이상이어야 합니다.");
        }
    }

    private static boolean isNaturalNumber(int numberOfRow) {
        return numberOfRow > 2;
    }

    public int getNumberOfRow() {
        return numberOfRow;
    }
}
