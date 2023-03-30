package KuitMission.creator;

import KuitMission.ladder.Ladder;
import KuitMission.ladder.Row;

public class RandomLadderCreator implements LadderCreator {
    Ladder ladder;


    @Override
    public Ladder createLadder(int numofPerson, int heightofLadder) {
        Ladder ladder = new Ladder(numofPerson, heightofLadder);
        ladder.rows = new Row[heightofLadder + 1];
        for (int i = 0; i < heightofLadder + 1; i++) {
            ladder.rows[i] = new Row(numofPerson);
        }
        return ladder;
    }


    @Override
    public Ladder drawLine(Ladder ladder, int numofLadder, int y) {
        return null;
    }

    //추가 기능. 사다리 선 자동으로 그리는 기능
    //사다리 Line 생성 함수
    //인자값 : 사다리 번호(1부터), 사다리 행 번호(0부터)
    //메서드 오버로딩 사용
    public Ladder drawLine(int numofLadder, int y) {
        ladder.rows[y].draw(numofLadder);
        return ladder;
    }
}
