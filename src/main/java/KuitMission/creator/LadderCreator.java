package KuitMission.creator;

import KuitMission.ladder.Ladder;

public interface LadderCreator {
    //기능 1. 사다리 생성
    Ladder createLadder(int personCount, int ladderHeight);


    //기능 2. 사다리 선 그리기
    Ladder drawLine(Ladder ladder, int numofLadder, int y);
}
