package KuitMission.creator;

import KuitMission.ladder.Ladder;
import KuitMission.ladder.Row;

public class DesignLadderCreator implements LadderCreator {
    Ladder ladder;
    @Override
    public Ladder createLadder(int numofPerson, int heightofLadder) {
        ladder = new Ladder(numofPerson,heightofLadder);
        ladder.rows=new Row[heightofLadder+1];
        for (int i=0;i<heightofLadder+1;i++){
            ladder.rows[i]=new Row(numofPerson);
        }
        return ladder;
    }

    //추가 기능. 사다리 선 그리는 기능
    //사다리 Line 생성 함수
    //인자값 : 사다리 번호(1부터), 사다리 행 번호(0부터)
    public Ladder drawLine(int numofLadder,int y){
        validateNumofRow(y);
        ladder.rows[y].draw(numofLadder);
        return ladder;
    }

    private void validateNumofRow(int y) {
        if(y<0){
            throw new IllegalArgumentException("y좌표가 음수입니다.");
        }
        if(y>=ladder.rows.length){
            throw new IllegalArgumentException("y좌표가 사다리높이 범위를 넘어섰습니다.");
        }
    }
}
