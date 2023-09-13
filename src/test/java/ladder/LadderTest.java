package ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class LadderTest {


    Ladder ladder;

    //길이 5, 사람 수 5로 초기화
    @BeforeEach
    public void beforeTest() {
        ladder = new Ladder(10, 5);
    }


//Constructor Test/////////////////////////////////////////

    //생성자 생성시 비정상적인 값이 들어오는지?
    @Test
    @DisplayName("constructor : Validation Create Error")
    public void validCreate() {

        //ladderLength 비정상값
        assertThrows(IllegalArgumentException.class, () -> new Ladder(-1, 10));

        //numberOfPerson 비정상값
        assertThrows(IllegalArgumentException.class, () -> new Ladder(10, -1));

        //정상값
        assertDoesNotThrow(() -> new Ladder(1,1));

    }
/////////////////////////////////////////////////////



//drawLine Test/////////////////////////////////////////


    //drawLine을 할 때 index가 정상 범위인지?
    @Test
    @DisplayName("drawLine : Validation drawLine")
    public void drawLine() {
        //row가 범위 밖
        assertThrows(IllegalArgumentException.class,() -> ladder.drawLine(1000, 0, Direction.RIGHT));
        assertThrows(IllegalArgumentException.class,() -> ladder.drawLine(-1000, 0, Direction.RIGHT));
        //col이 범위 밖
        assertThrows(IllegalArgumentException.class,() -> ladder.drawLine(0, 1000, Direction.RIGHT));
        assertThrows(IllegalArgumentException.class,() -> ladder.drawLine(0, -1000, Direction.RIGHT));

        //경계값테스트
        assertThrows(IllegalArgumentException.class,() -> ladder.drawLine(5, 5, Direction.RIGHT));
        assertThrows(IllegalArgumentException.class,() -> ladder.drawLine(-1, -1, Direction.RIGHT));

        assertEquals(true, ladder.drawLine(0, 0, Direction.RIGHT));
        assertEquals(true, ladder.drawLine(4, 4, Direction.LEFT));

        //최좌측에서 왼쪽으로 사다리 연결
        assertEquals(false, ladder.drawLine(0, 0, Direction.LEFT));
        //최우측에서 오른쪽으로 사다리 연결
        assertEquals(false, ladder.drawLine(0, 4, Direction.RIGHT));
    }




/////////////////////////////////////////////////////


//Run Test///////////////////////////////////////////

    //시작 person의 위치가 정상적인지?
    @Test
    @DisplayName("run : Validation Start Person")
    public void person() {
        //시작 위치가 음수
        assertThrows(IllegalArgumentException.class,() -> ladder.run(-100));
        //시작 위치가 사다리 초과
        assertThrows(IllegalArgumentException.class,() -> ladder.run(100));

        //경계값테스트
        assertEquals(0, ladder.run(0));
        assertEquals(4, ladder.run(4));
        assertThrows(IllegalArgumentException.class,() -> ladder.run(-5));
        assertThrows(IllegalArgumentException.class,() -> ladder.run(5));
    }

    //선이 없을 때 쭉 내려오는지?
    @Test
    @DisplayName("run : Only One Ladder")
    public void oneLadder() {
        ladder = new Ladder(10, 1);
        assertEquals(0, ladder.run(0));
    }

    //중간에 선을 만났을 때 건너가지는지 - 2개 사다리 1개 선
    @Test
    @DisplayName("run : 2 Ladder 1 Line")
    public void twoLadderOneLine() {
        ladder = new Ladder(10, 2);
        ladder.drawLine(1, 1, Direction.LEFT);
        assertEquals(1, ladder.run(0));
    }




    //정상 작동
    @Test
    @DisplayName("run : Normal Operation")
    public void run() {
        ladder.drawLine(1, 1, Direction.RIGHT);
        ladder.drawLine(2, 0, Direction.RIGHT);
        ladder.drawLine(3, 3, Direction.LEFT);
        ladder.drawLine(1, 4, Direction.LEFT);

        assertEquals(3, ladder.run(1));
    }

/////////////////////////////////////////////////////


}