package KuitMission.manager;

import KuitMission.LadderConfig;
import KuitMission.ladder.Ladder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderManagerTest {
    LadderManager ladderManager;

    @BeforeEach
    void beforeEach() {
        LadderConfig ladderConfig = new LadderConfig();
        ladderManager = ladderConfig.ladderManager();

        ladderManager.createLadder(3, 6);
    }

    //LadderCreator 테스트
    @Test
    @DisplayName("Create Ladder")
    void getLadder() {
        //높이가 6이면 행 개수는 7
        int[] expected = {7, 3};
        //ladder클래스의 row 행의 길이와 ladder 클래스의 rows 배열의 첫번째 인덱스의 열 개수
        int[] actual = {ladderManager.getLadder().rows.length, ladderManager.getLadder().rows[0].numofCol};
        assertArrayEquals(expected, actual);
    }

    //drawLine 테스트-성공
    @Test
    @DisplayName("Make Line-성공")
    void drawLine() {
        ladderManager.drawLine(1, 1);
        int[] expected = {1, 1};
        int[] actual = {ladderManager.getLadder().rows[1].getHere(1), ladderManager.getLadder().rows[1].getHere(0)};
        assertArrayEquals(expected, actual);
    }

    //drawLine 테스트-실패
    @Test
    @DisplayName("Make Line-실패")
    void drawWrongRange() {
        assertThrows(IllegalArgumentException.class, () ->
                ladderManager.drawLine(4, 3));
    }

    //run 테스트 - 빈 사다리
    @Test
    @DisplayName("Run Empty Ladder")
    void runEmptyLadder() {
        assertEquals(1, ladderManager.run(ladderManager.getLadder(), 1));
    }

    //run 테스트 - 안 비어있는 사다리
    @Test
    @DisplayName("Run Ladder")
    void runLadder() {
        ladderManager.drawLine(1, 1);
        ladderManager.drawLine(2, 4);
        assertEquals(3, ladderManager.run(ladderManager.getLadder(), 1));
    }

    //print 테스트
    @Test
    @DisplayName("Print Ladder")
    void printLadder() {
        //ladderManager.print(ladderManager.getLadder());
    }
}