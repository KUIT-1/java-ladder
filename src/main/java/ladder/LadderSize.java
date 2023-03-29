package ladder;

import java.util.Objects;

public class LadderSize implements Comparable<LadderSize>{
    NaturalNumber row;
    NaturalNumber col;
    float randomRate = (float) 0.3;

    public LadderSize(int row, int col) {
        this.row = NaturalNumber.createNaturalNumber(row);
        this.col = NaturalNumber.createNaturalNumber(col);
    }

    public static LadderSize createLadderSize(int row, int col){
        return new LadderSize(row,col);
    }

    public int getRandomNumber(){
        return (int) (row.getNumber()*col.getNumber()*randomRate);
    }

    public int getRandomRow(){
        return (int) (Math.random()*row.getNumber());
    }

    public int getRandomCol(){
        return (int) (Math.random()*(col.getNumber()-1));
    }

    @Override
    public int compareTo(LadderSize ladderSize) {
        if((this.row == ladderSize.row)&& (this.col == ladderSize.col)) return 0;
        return 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderSize that = (LadderSize) o;
        return Objects.equals(row, that.row) && Objects.equals(col, that.col);
    }

    @Override
    public int hashCode() {
        return this.row.getNumber()*10+this.col.getNumber();
    }
}
