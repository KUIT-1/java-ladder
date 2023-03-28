package ladder;

import java.util.Objects;

public class LadderSize implements Comparable<LadderSize>{
    int row;
    int col;
    float randomRate = (float) 0.3;

    public LadderSize(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public static LadderSize createLadderSize(int row, int col){
        return new LadderSize(row,col);
    }

    public int getRandomNumber(){
        return (int) (row*col*randomRate);
    }

    public int getRandomRow(){
        return (int) (Math.random()*row);
    }

    public int getRandomCol(){
        return (int) (Math.random()*(col-1));
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
        return this.row*10+this.col;
    }
}
