package ladder;

import static ladder.DrawLadder.createDrawLadder;
import static ladder.Position.createPosition;


//사다리 실행 클래스
public class LadderRunner {

    private Col cols[];

    public LadderRunner(Col[] cols) {
        this.cols = cols;
    }

    //* 실행 함수
    //start : 시작 위치
    public int run(int start) {

        //시작전 2초 대기 - 컴파일 시간을 주기 위함
        try{Thread.sleep(2000);} catch(InterruptedException e) {}

        //정답 줄 변수
        Position ans_col = createPosition(start, cols.length);
        //끝 만나기 전에 좌로 갈지 우로 갈지 체크 후 이동
        for(int i = 0; i < cols[0].getColLength(); i++) {
            Position ans_row = createPosition(i, cols[0].getColLength());

            //사다리 출력
            createDrawLadder(cols, ans_col, ans_row);

            //변수 생성
            Col col = cols[ans_col.getPosition()];
            int tmp = ans_col.getPosition();

            //방향값을 확인하고 더해줌
            ans_col.addPosition(col.checkDirection(i));

            //ans_col에게 변경이 없을 경우 스킵
            if(ans_col.getPosition() == tmp)continue;
            //변경이 있을 경우 출력
            createDrawLadder(cols, ans_col, ans_row);
        }

        //마지막 위치 return
        return ans_col.getPosition();
    }
}
