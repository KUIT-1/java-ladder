package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LadderTest {
    @Test
    @DisplayName("drawLine의 범위 초과")
    void drawLineValidate() {
        //when
        int numberOfPerson = 4;
        int row = 3;
        Ladder ladder = new Ladder(row, numberOfPerson);

        //given
        int givenRow = 4;
        int givenCol = 1;

        //then
        assertThrows(IllegalArgumentException.class,()->ladder.drawLine(givenRow,givenCol));
    }

    @Test
    @DisplayName("nOfPosition의 범위 초과")
    void nOfPersonValidate() {
        //when
        int numberOfPerson = 4;
        int row = 3;
        Ladder ladder = new Ladder(row, numberOfPerson);

        //given
        int nOfPerson = 4;

        //then
        assertThrows(IllegalArgumentException.class,()->ladder.run(nOfPerson));

        //given
        int nOfPerson2 = -1;

        //then
        assertThrows(IllegalArgumentException.class,()->ladder.run(nOfPerson2));

    }

    @Test
    @DisplayName("run 실행 확인")
    void FourRowFourColWithLine() {
        //when
        int numberOfPerson = 4;
        int row = 4;
        Ladder ladder = new Ladder(row, numberOfPerson);

        //given
        ladder.drawLine(0,1);
        ladder.drawLine(1,0);
        ladder.drawLine(2,2);

        int nthOfPerson = 0;
        //then
        assertEquals(1,ladder.run(nthOfPerson));

        nthOfPerson = 3;

        assertEquals(2,ladder.run(nthOfPerson));
    }

    @Test
    @DisplayName("초기 사다리 실행 확인")
    void ZeroLineWithLine() {
        //when
        int numberOfPerson = 4;
        int row = 4;
        Ladder ladder = new Ladder(row, numberOfPerson);

        int nthOfPerson = 1;
        //then
        assertEquals(1,ladder.run(nthOfPerson));

        nthOfPerson = 2;

        assertEquals(2,ladder.run(nthOfPerson));
    }
}