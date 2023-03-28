package ladder;

import ladder.creator.LadderCreator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static ladder.LadderSize.createLadderSize;
import static ladder.creator.LadderNormalCreator.createLadderNormalCreator;
import static ladder.creator.LadderRandomCreator.createLadderRandomCreator;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LadderRunnerTest {

    LadderCreator lc;
    LadderRunner ladderRunner;

//Run Test///////////////////////////////////////////
    
    @BeforeEach
    public void BeforeTest() {
        lc = createLadderRandomCreator(createLadderSize(10,5));
        ladderRunner = new LadderRunner(lc.getCols());
    }

    //시작 person의 위치가 정상적인지?
    @Test
    @DisplayName("run : Validation Start Person")
    public void person() {
        //시작 위치가 음수
        assertThrows(IllegalArgumentException.class,() -> ladderRunner.run(-100));
        //시작 위치가 사다리 초과
        assertThrows(IllegalArgumentException.class,() -> ladderRunner.run(100));

        //경계값테스트
        assertEquals(0, ladderRunner.run(0));
        assertEquals(4, ladderRunner.run(4));
        assertThrows(IllegalArgumentException.class,() -> ladderRunner.run(-5));
        assertThrows(IllegalArgumentException.class,() -> ladderRunner.run(5));
    }

    //선이 없을 때 쭉 내려오는지?
    @Test
    @DisplayName("run : Only One Ladder")
    public void oneLadder() {
        lc = createLadderNormalCreator(createLadderSize(10, 1));
        ladderRunner = new LadderRunner(lc.getCols());
        assertEquals(0, ladderRunner.run(0));
    }

    //중간에 선을 만났을 때 건너가지는지 - 2개 사다리 1개 선
    @Test
    @DisplayName("run : 2 Ladder 1 Line")
    public void twoLadderOneLine() {
        lc = createLadderNormalCreator(createLadderSize(10, 2));
        lc.drawLine(1,1,Direction.LEFT);
        ladderRunner = new LadderRunner(lc.getCols());
        assertEquals(1, ladderRunner.run(0));
    }




    //정상 작동
    @Test
    @DisplayName("run : Normal Operation")
    public void run() {
        lc = createLadderNormalCreator(createLadderSize(10, 5));

        lc.drawLine(1, 1, Direction.RIGHT);
        lc.drawLine(2, 0, Direction.RIGHT);
        lc.drawLine(3, 3, Direction.LEFT);
        lc.drawLine(1, 4, Direction.LEFT);

        ladderRunner = new LadderRunner(lc.getCols());


        assertEquals(3, ladderRunner.run(1));
    }

/////////////////////////////////////////////////////

}
