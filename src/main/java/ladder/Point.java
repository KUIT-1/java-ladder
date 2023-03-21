package ladder;

public class Point {
    private final int value;

    public Point(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if(value <= 0){
            throw new IllegalArgumentException("잘못된 값이 입력되었습니다.");
        }
    }

    public int getValue() {
        return value;
    }
}
