package ladder;

public class Ladder {

    private final int[][] rows;
    int height;
    int numberOfPerson;

    public Ladder(int height, int numberOfPerson) {
        this.height = height;
        this.numberOfPerson = numberOfPerson;
        rows = new int[height+1][numberOfPerson+1];

    }

    public int run(int startNumber) {
        int num = startNumber;
        for(int curHeight = 1; curHeight <= height; curHeight++){
            if(rows[curHeight][num]==0) continue;
            if(rows[curHeight][num]==1){
                num++;
                continue;
            }
            if(rows[curHeight][num]==-1){
                num--;
                continue;
            }
        }
        return num;
    }

    public void drawLine(int row, int col) {
        rows[row][col] = 1;
        rows[row][col+1] = -1;
    }
}
