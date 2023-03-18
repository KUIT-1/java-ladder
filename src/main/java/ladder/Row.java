package ladder;


public class Row {

    //행 - 사다리에서 세로줄 담당
    int[] row;

    //생성자
    public Row(int row) {
        this.row = new int[row];
    }


    //가고 싶어 하는 위치를 저장
    public void drawLine(int current, int direction) {
        row[current] = direction;
    }


    //현 위치에서 어느 행으로 가는지 반환
    public int checkDirection(int current) {
        return row[current];
    }


}
