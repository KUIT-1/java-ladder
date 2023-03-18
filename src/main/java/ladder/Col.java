package ladder;

public class Col {

    //행 - 사다리에서 세로줄 담당
    int[] col;

    //생성자
    public Col(int col) {
        this.col = new int[col];
    }


    //* 가고 싶어 하는 위치를 저장 함수
    public void drawLine(int current, int direction) {col[current] = direction;}


    //* 현 위치에서 어느 열로 가는지 반환 함수
    public int checkDirection(int current) {
        return col[current];
    }




}
