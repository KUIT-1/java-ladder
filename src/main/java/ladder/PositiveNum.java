package ladder;

//음수 무결성 검사(0 혹은 양수)
//음수일 시 에러 발생, 아닐 시 저장
public class PositiveNum {
    private int num;

    private PositiveNum(int num) {
        this.num = num;
    }

    //* 정적인 팩토리 메서드
    //책임을 한 곳에 모아둘 수 있는 방법
    public static PositiveNum createPositiveNumber(int number) {
            validNegative(number);
            return new PositiveNum(number);
    }

    //* 음수 검사 함수

    //음수일 시 에러 발생
    public static void validNegative(int value) {
        if(value < 0) throw new IllegalArgumentException("음수는 사용할 수 없습니다.");
    }

    public int getNum() {return num;}
    public void addNum(int num) {
        this.num += num;
    }
}
