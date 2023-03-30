package KuitMission.manager;

import KuitMission.ladder.Ladder;

public interface LadderManager {
    //1. 사다리 생성 기능
    void createLadder(int numberOfPeople, int ladderHeight);

    //2. 사다리 선 그리는 기능
    void drawLine(int numberOfPeople, int y);

    //3. 사다리 타는 기능
    int run(Ladder laddder, int startNumofLadder);

    //4. 사다리 출력 기능
    void print(Ladder ladder);

    //5. 사다리 정보 반환 기능
    Ladder getLadder();
}
