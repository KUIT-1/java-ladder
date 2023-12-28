package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    //Ladder ladder = new Ladder(int start);
    @Test
    @DisplayName("사다리 세로 줄이 한개")
    void line1(){
        int numberOfPerson = 1;

        Ladder ladder = new Ladder(1, 1);
        assertEquals(1, ladder.run(1));
    }


    @Test
    @DisplayName("세로줄 2개")
    void drawLineTest(){
        Ladder ladder = new Ladder(4, 3);
        ladder.drawLine(2, 1);
        assertEquals(3,ladder.run(2));
    }
}