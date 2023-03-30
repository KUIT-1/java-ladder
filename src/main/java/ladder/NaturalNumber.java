package ladder;

public class NaturalNumber {

    private final int number;
    private static final int START_INDEX = 1;

    private NaturalNumber(int number) {
        this.number = number;
    }

    public static NaturalNumber createNaturalNumber(int number){
        validateNumber(number);
        return new NaturalNumber(number);
    }

    private static void validateNumber(int number){
        if(number < START_INDEX)
            throw new IllegalArgumentException("자연수가 아닙니다.");
    }

    public int getNumber(){
        return number;
    }
}
