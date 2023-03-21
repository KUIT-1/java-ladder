package ladder;

public class Ladder {

    int nOfRow = 0;
    int nOfcol = 0;
    private final int[][] rows; //사다리

    //row : 사다리의 높이, numberofPerson : 사다리 줄의 수
    public Ladder(int row, int numberOfPerson) {
        this.nOfRow = row - 1;
        this.nOfcol = numberOfPerson - 1;
        rows = new int[row][numberOfPerson];
    }

    public void drawLine(int row, int col){
        invalidatePosition(row,col);
        rows[row][col] = 1;
        rows[row][col+1] = -1;
    }

    public int run(int nOfPerson){
        invalidateNOfPerson(nOfPerson);
        int current = nOfPerson;
        for (int i = 0; i < nOfRow; i++) {
            if(rows[i][current] == 1) current++;
            else if(rows[i][current] == -1) current--;
        }
        return current;
    }

    /*
    0번째 행 가능 , 마지막 행 불가능
    0번째 열 가능 , 마지막 열 불가능
     */
    private void invalidatePosition(int row, int col){
        if ((row<0)||(row>=nOfRow)||(col<0)||(col>=nOfcol)){
            throw new IllegalArgumentException();
        }
    }

    private void invalidateNOfPerson(int nOfPerson){
        if ((nOfPerson<0)||(nOfPerson>nOfcol)){
            throw new IllegalArgumentException();
        }
    }


}
