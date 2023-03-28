package ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class LadderGameTest {


    LadderGame ladderGame;

    //길이 5, 사람 수 5로 초기화
    @BeforeEach
    public void beforeTest() {
        ladderGame = LadderGameFactory.createNormalLadderGame(10, 5);
    }





//drawLine Test/////////////////////////////////////////


    //drawLine을 할 때 index가 정상 범위인지?
    @Test
    @DisplayName("drawLine : Validation drawLine")
    public void drawLine() {
        //row가 범위 밖
        assertThrows(IllegalArgumentException.class,() -> ladderGame.drawLine(1000, 0, Direction.RIGHT));
        assertThrows(IllegalArgumentException.class,() -> ladderGame.drawLine(-1000, 0, Direction.RIGHT));
        //col이 범위 밖
        assertThrows(IllegalArgumentException.class,() -> ladderGame.drawLine(0, 1000, Direction.RIGHT));
        assertThrows(IllegalArgumentException.class,() -> ladderGame.drawLine(0, -1000, Direction.RIGHT));

        //경계값테스트
        assertThrows(IllegalArgumentException.class,() -> ladderGame.drawLine(5, 5, Direction.RIGHT));
        assertThrows(IllegalArgumentException.class,() -> ladderGame.drawLine(-1, -1, Direction.RIGHT));

        assertEquals(true, ladderGame.drawLine(0, 0, Direction.RIGHT));
        assertEquals(true, ladderGame.drawLine(4, 4, Direction.LEFT));

        //최좌측에서 왼쪽으로 사다리 연결
        assertEquals(false, ladderGame.drawLine(0, 0, Direction.LEFT));
        //최우측에서 오른쪽으로 사다리 연결
        assertEquals(false, ladderGame.drawLine(0, 4, Direction.RIGHT));
    }




/////////////////////////////////////////////////////



}