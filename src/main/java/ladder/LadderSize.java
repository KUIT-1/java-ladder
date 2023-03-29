package ladder;

public class LadderSize {
    NaturalNumber row;
    NaturalNumber numberOfPerson;

    private LadderSize(NaturalNumber row, NaturalNumber numberOfPerson) {
        this.row = row;
        this.numberOfPerson = numberOfPerson;
    }
    public static LadderSize createLadderSize(NaturalNumber row, NaturalNumber numberOfPerson){
        return new LadderSize(row, numberOfPerson);
    }

    public NaturalNumber getRow() {
        return row;
    }

    public NaturalNumber getNumberOfPerson() {
        return numberOfPerson;
    }
}
