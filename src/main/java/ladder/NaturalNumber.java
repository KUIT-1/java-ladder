package ladder;

public class NaturalNumber {

    private final int number;

    private NaturalNumber(int number) {
        this.number = number;
    }

    public static NaturalNumber createNaturalNumber(int number){
        validateNumber(number);
        return new NaturalNumber(number);
    }

    private static void validateNumber(int number){
        if(number <= 0)
            throw new IllegalArgumentException("자연수가 아닙니다.");
    }

    public int getNumber(){
        return number;
    }
}
