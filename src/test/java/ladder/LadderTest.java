import ladder.Ladder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadderTest {
    @Test
    @DisplayName("사람수 : 1명, 가로줄 : 0개")
    void person1_line0(){
        Ladder ladder = new Ladder(4, 1);
        assertEquals(0, ladder.run(0));
    }

    @Test
    @DisplayName("사람수:2명, 가로줄:1개")
    void people2_line1(){
        Ladder ladder = new Ladder(4, 2);
        ladder.drawLine(1, 0);
        assertEquals(1, ladder.run(0));
        assertEquals(0, ladder.run(1));
    }

    @Test
    @DisplayName("사람수:2명, 가로줄:2개")
    void people2_lien2(){
        Ladder ladder = new Ladder(4, 2);
        ladder.drawLine(1, 0);
        ladder.drawLine(3, 0);
        assertEquals(0, ladder.run(0));
    }

    @Test
    @DisplayName("사람수:4명, 가로줄:5개")
    void people4_line5(){
        Ladder ladder = new Ladder(5, 4);
        ladder.drawLine(0, 0);
        ladder.drawLine(1, 1);
        ladder.drawLine(2, 2);
        ladder.drawLine(3, 1);
        ladder.drawLine(4, 0);
        assertEquals(3, ladder.run(0));
    }
}
