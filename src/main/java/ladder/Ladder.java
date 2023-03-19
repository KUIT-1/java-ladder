package ladder;

public class Ladder {

    private final int[][] rows;
    int height;
    int numberOfPerson;

    public Ladder(int height, int numberOfPerson) {
        this.height = height;
        this.numberOfPerson = numberOfPerson;
        rows = new int[height+1][numberOfPerson+1];
        validateLadder();
    }

    private void validateLadder() {
        if(height <= 0 || numberOfPerson <= 0)
            throw new IllegalArgumentException("높이와 인원수는 1 이상이어야 합니다.");
    }

    public int run(int startNumber) {
        validateStartNumber(startNumber);
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

    private void validateStartNumber(int startNumber) {
        if(startNumber < 1 || startNumber > numberOfPerson)
            throw new IllegalArgumentException("시작점의 값이 유효하지 않습니다.");
    }

    public void drawLine(int row, int col) {
        rows[row][col] = 1;
        rows[row][col+1] = -1;
    }
}
