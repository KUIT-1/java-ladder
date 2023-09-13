package ladder;

//음수 무결성 검사(0 혹은 양수)
//음수일 시 에러 발생, 아닐 시 저장
public class PositiveNum {
    private int num;

    public PositiveNum(int num) {
        validNegative(num);
        this.num = num;
    }

    //* 음수 검사 함수

    //음수일 시 에러 발생
    public void validNegative(int value) {
        if(value < 0) throw new IllegalArgumentException("음수는 사용할 수 없습니다.");
    }

    public int getNum() {return num;}
    public void addNum(int num) {
        this.num += num;
    }
}
