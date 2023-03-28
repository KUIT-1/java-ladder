package ladder;

import static ladder.PositiveNum.createPositiveNumber;
//사다리 크기, 사이즈 클래스
public class LadderSize {

    PositiveNum ladderLength;
    PositiveNum numberOfPerson;
    private LadderSize(PositiveNum ladderLength, PositiveNum numberOfPerson) {
        this.ladderLength = ladderLength;
        this.numberOfPerson = numberOfPerson;
    }


    public static LadderSize createLadderSize(int ladderLength, int numberOfPerson) {
        return new LadderSize(createPositiveNumber(ladderLength), createPositiveNumber(numberOfPerson));
    }

    public int getLadderLength() {
        return ladderLength.getNum();
    }

    public int getNumberOfPerson() {
        return numberOfPerson.getNum();
    }


    public int getNumberOfLine() {
        return (int) (ladderLength.getNum() * numberOfPerson.getNum() * 0.3);
    }
}
