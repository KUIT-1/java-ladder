package ladder;

public class NaturalNumber {
    private final int number;

    //pricate
    private NaturalNumber(int number) {
        valitdateNumber(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    // validation 처리를 이 내부에서 해주기
    private void valitdateNumber(int number){
        if(number<=0){
            throw new IllegalArgumentException("자연수는 1 이상이어야 합니다.")
        }
    }
}
