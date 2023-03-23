package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadderTest {
    @Test
    @DisplayName("run 실행 확인")
    void runSuccessWhenFourRowFourColFourLine() {
        //when
        int numberOfPerson = 4;
        int row = 4;
        Ladder ladder = new Ladder(row, numberOfPerson);

        //given
        ladder.drawLine(0,1);
        ladder.drawLine(1,0);
        ladder.drawLine(2,2);
        ladder.drawLine(3,0);

        int position = 0;
        //then
        assertEquals(0,ladder.run(position));

        position = 3;

        assertEquals(2,ladder.run(position));
    }

    @Test
    @DisplayName("초기 사다리 실행 확인")
    void runSuccessWhenFourRowFourColNoLine() {
        //when
        int numberOfPerson = 4;
        int row = 4;
        Ladder ladder = new Ladder(row, numberOfPerson);

        int position = 1;
        //then
        assertEquals(1,ladder.run(position));

        position = 3;

        assertEquals(3,ladder.run(position));
    }
}