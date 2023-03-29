package ladder;

import java.util.Random;

public class LadderSize {
    private final NaturalNumber row;
    private final NaturalNumber col;

    private LadderSize(NaturalNumber row, NaturalNumber col) {
        this.row = row;
        this.col = col;
    }

    public static LadderSize createRandomLadderSize(){
        Random random = new Random();

        NaturalNumber row = NaturalNumber.createNaturalNumber(random.nextInt(9)+2);
        NaturalNumber col = NaturalNumber.createNaturalNumber(random.nextInt(9)+3);

        return new LadderSize(row, col);
    }

    public static LadderSize createLadderSize(NaturalNumber row, NaturalNumber col){
        return new LadderSize(row, col);
    }

    public NaturalNumber numOfLine(){
        int i = (int) (row.getNumber()*col.getNumber()*0.3);
        NaturalNumber number = NaturalNumber.createNaturalNumber(i);
        return number;
    }

    public NaturalNumber getRowSize(){
        return row;
    }

    public NaturalNumber getColSize(){
        return col;
    }

}
