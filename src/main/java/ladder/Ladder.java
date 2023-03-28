package ladder;

public class Ladder {
    Row rows[]; //각 행 정보를 담은 일차원 배열

    //사다리 생성자
    //이차원배열 -> 일차원배열
    //변수 이름도 더 직관적으로! num-> numofPerson , height -> heightofLadder
    public Ladder(int numofPerson,int heightofLadder){
        this.rows=new Row[heightofLadder+1];
        for (int i=0;i<heightofLadder+1;i++){
            rows[i]=new Row(numofPerson);
        }
    }
    //사다리 Line 생성 함수
    //인자값 : 사다리 번호(1부터), 사다리 행 번호(0부터)
    void drawLine(int numofLadder,int y){
        validateNumofRow(y);
        rows[y].draw(numofLadder);
    }

    private void validateNumofRow(int y) {
        if(y<0){
            throw new IllegalArgumentException("y좌표가 음수입니다.");
        }
        if(y>=rows.length){
            throw new IllegalArgumentException("y좌표가 사다리높이 범위를 넘어섰습니다.");
        }
    }

    //사다리 타는 함수
    //인자값: 몇번째 사다리로 들어가는지
    //반환값: 몇번째 사다리로 나오는지
    int run(int startNumofLadder){
        validateStartNum(startNumofLadder);
        int nowColofLadder=startNumofLadder-1; //정답을 저장할 변수
        int nowRowNumofLadder=0; //현재 행 위치
        nowRowNumofLadder++; //한칸 이동
        while(nowRowNumofLadder<rows.length) { //현재 행 위치가 사다리 행 수보다 작을동안 진행
            //checkNext-> 이름대로 다음 위치를 체크만 하도록 하자!!
            int next=checkNext(nowColofLadder,nowRowNumofLadder);
            switch (next){
                case -1 : {
                    nowColofLadder-=1;
                    break;
                }
                case 0 : break;
                case 1 : nowColofLadder+=1;
            }
            nowRowNumofLadder++; //한칸 이동
        }
        return nowColofLadder+1;
    }

    private void validateStartNum(int numofLadder) {
        if(numofLadder<1){
            throw new IllegalArgumentException("사다리번호가 0 또는 음수입니다.");
        }
        if(numofLadder>rows.length){
            throw new IllegalArgumentException("사다리번호가 사다리 개수를 넘어섰습니다.");
        }
    }

    private int checkNext(int nowColofLadder, int nowRowNumofLadder) {
        //오른쪽 이동 1, 왼쪽 이동 -1, 그냥 아래로 이동 0
        if(rows[nowRowNumofLadder].checkHere(nowColofLadder)==1){
            if (nowColofLadder == 0) {
                return 1;//오른쪽 점 확인 할 필요 없이 오른쪽 이동
            }
            if (nowColofLadder == rows[0].cols.length-1)
                return -1;//왼쪽 점 확인 할 필요 없이 왼쪽 이동
            //오른쪽 왼쪽 점 확인 후 이동
            if(rows[nowRowNumofLadder].checkRight(nowColofLadder)==1)
                return 1; //오른쪽 이동
            return -1; //왼쪽 이동
        }
        return 0; // 아무것도 아니면 그냥 x 반환
    }
}