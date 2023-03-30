package KuitMission.ladder;

public class Row {
    public static final int LADDER_CHECKED = 1;
    public int cols[];
    public int numofCol;

    public Row(int col) {
        this.numofCol = col; //사다리 개수
        this.cols = new int[col];
    }

    //인자값 : 사다리 번호
    //x좌표와 x+1좌표의 값을 1로 만들어주는 함수
    //인자값이 사다리 번호 (1부터 시작) 이므로 일차원 배열 index에 맞춰 numofLadder와 numofLadder-1에 1 할당
    public void draw(int numofLadder) {
        validateDraw(numofLadder);
        cols[numofLadder] = LADDER_CHECKED;
        cols[numofLadder - 1] = LADDER_CHECKED;
    }

    //draw 시 넘어온 사다리 번호 유효성 확인
    private void validateDraw(int numofLadder) {
        if (numofLadder < 1) {
            throw new IllegalArgumentException("사다리번호가 0 또는 음수입니다.");
        }
        if (numofLadder == numofCol) {
            throw new IllegalArgumentException("맨 오른쪽 사다리로 더이상 line을 그릴 수 없습니다.");
        }
        if (numofLadder > numofCol) {
            throw new IllegalArgumentException("사다리번호가 사다리 개수를 넘어섰습니다.");
        }
    }

    //boolean -> 체크용도 -> checkLine 같은 게 더 나음~
    //현 위치 정보 반환
    public int getHere(int xPos) {
        return cols[xPos];
    }

    //현 위치의 오른쪽 정보 반환
    public int checkRight(int nowColofLadder) {
        return cols[nowColofLadder + 1];
    }
}
