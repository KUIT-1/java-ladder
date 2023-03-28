package KuitMission.creator;

import KuitMission.ladder.Ladder;

public interface LadderCreator {
    //기능 1. 사다리 생성
    Ladder createLadder(int numofPerson, int heightofLadder);
    //기능 2. 사다리 선 그리기
    Ladder drawLine(int numofLadder,int y);
}
