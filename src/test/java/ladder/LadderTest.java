package ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfSystemProperties;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {
    Ladder ladder;

    @BeforeEach
    void init() { ladder = new Ladder(3,6); }
    //생성자 테스트
    @Test
    @DisplayName("Make Ladder")
    void getLadder(){
        //높이가 6이면 행 개수는 7
        int[] expected={7,3};
        //ladder클래스의 row 행의 길이와 ladder 클래스의 rows 배열의 첫번째 인덱스의 열 개수
        int[] actual={ladder.rows.length,ladder.rows[0].numofCol};
        assertArrayEquals(expected,actual);
    }
    //drawLine 테스트-성공
    @Test
    @DisplayName("Make Line-성공")
    void drawLine(){
        ladder.drawLine(1,1);
        int[] expected={1,1};
        int[] actual={ladder.rows[1].checkHere(1),ladder.rows[1].checkHere(0)};
        assertArrayEquals(expected,actual);
    }
    //drawLine 테스트-실패
    @Test
    @DisplayName("Make Line-실패")
    void drawWrongRange(){
        assertThrows(IllegalArgumentException.class,()->
                ladder.drawLine(4,3));
    }
    //run 테스트 - 빈 사다리
    @Test
    @DisplayName("Run Empty Ladder")
    void runEmptyLadder(){
        assertEquals(1,ladder.run(1));
    }
    //run 테스트 - 안 비어있는 사다리
    @Test
    @DisplayName("Run Ladder")
    void runLadder(){
        ladder.drawLine(1,1);
        ladder.drawLine(2,4);
        assertEquals(3,ladder.run(1));
    }
}