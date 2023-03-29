package ladder;

public class LadderSize {
    NaturalNumber row;
    NaturalNumber numberOfPerson;

    public LadderSize(NaturalNumber row, NaturalNumber numberOfPerson) {
        this.row = row;
        this.numberOfPerson = numberOfPerson;
    }

    public int getRowValue() {
        return row.getNumber();
    }

    public int getNumberOfPersonValue() {
        return numberOfPerson.getNumber();
    }

    public int getLadderSize() {
        return getRowValue() * getNumberOfPersonValue();
    }

    public static LadderSize createLadderSize(NaturalNumber row, NaturalNumber numberOfPerson) {
        return new LadderSize(row, numberOfPerson);
    }
}
