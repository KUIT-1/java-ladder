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
        //높이가 6이면 열 개수는 7
        int[] expected={3,7};
        assertArrayEquals(expected,ladder.getInform());
    }
    //drawLine 테스트-성공
    @Test
    @DisplayName("Make Line")
    void drawLine(){
        ladder.drawLine(1,1);
        int[] expected={1,1};
        int[] actual={ladder.getArray()[1][1],ladder.getArray()[2][1]};
        assertArrayEquals(expected,actual);
    }
    //drawLine 테스트-실패
    @Test
    @DisplayName("Wrong Range")
    void drawWrongRange(){
        assertThrows(IllegalArgumentException.class,()->
                ladder.drawLine(2,3));
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
        ladder.drawLine(0,1);
        ladder.drawLine(1,4);
        assertEquals(3,ladder.run(1));
    }
}