package ladder;

public class NaturalNumber {

    private final int number;

    private NaturalNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    // 정적 팩토리 메서드 -> 객체를 생성하는 책임을 모아둔다(?)
    public static NaturalNumber createNaturalNumber(int number) {
        validationNaturalNumber(number);
        return new NaturalNumber(number);
    }

    private static void validationNaturalNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("자연수는 1 이상이어야 합니다.");
        }
    }
}
