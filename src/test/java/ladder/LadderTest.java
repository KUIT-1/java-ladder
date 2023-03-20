package ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LadderTest {
    Ladder ladder;

    @Test
    @DisplayName("사다리의 높이가 1 인 경우")
    public void noLineTest() {
        // when
        ladder = new Ladder(1, 10);
        // given
        int[] startPositionList = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        // then
        for (int j : startPositionList) {
            int result = ladder.run(j);
            Assertions.assertThat(result).isEqualTo(j);
        }
    }
    @Test
    @DisplayName("유효하지 않은 시작 위치가 주어진 경우")
    public void invalidRow(){
        // when
        ladder = new Ladder(1, 10);
        // given
        int[] givenPositionList = {-1, 11, 100};
        // then
        for(int pos : givenPositionList){
            assertThrows(IllegalArgumentException.class,
                    ()->ladder.run(pos));
        }
    }
    @Test
    @DisplayName("잘못된 위치에 Line 을 그리려고 하는 경우")
    public void invalidDraw(){
        // when
        ladder = new Ladder(5, 5);
        // given
        int row = 4;
        int col = 4;
        // then
        assertThrows(IllegalArgumentException.class,
                ()->ladder.drawLine(row, col));
    }
    @Test
    @DisplayName("Run Test #case 1")
    public void Testcase1(){
        // when
        ladder = new Ladder(5, 5);
        // given
        ladder.drawLine(0, 0);
        // then
        int startPosition = 0;
        int result = ladder.run(startPosition);
        Assertions.assertThat(result).isEqualTo(1);
    }
    @Test
    @DisplayName("Run Test #case 2")
    public void Testcase2(){
        // when
        ladder = new Ladder(5, 5);
        // given
        ladder.drawLine(0, 0);
        ladder.drawLine(1, 1);
        ladder.drawLine(2, 2);
        ladder.drawLine(3, 3);
        // then
        int startPosition = 0;
        int result = ladder.run(startPosition);
        Assertions.assertThat(result).isEqualTo(4);
    }

    @Test
    @DisplayName("Run Test #case 3")
    public void Testcase3(){
        // when
        ladder = new Ladder(100, 100);
        // given
        for(int i = 0 ; i < 99; i++){
            ladder.drawLine(i, i);
        }
        // then
        int expectedPosition;
        for(int startPosition = 0 ; startPosition <=99; startPosition++){
            int endPosition = ladder.run(startPosition);
            expectedPosition = startPosition - 1;
            if(startPosition == 0){
                expectedPosition = 99;
            }
            Assertions.assertThat(endPosition).isEqualTo(expectedPosition);
        }
    }

    @Test
    @DisplayName("Line Drawing Test")
    void drawLine() {
        // when
        ladder = new Ladder(5 , 10);

        //given
        int before = ladder.run(3);
        ladder.drawLine(3, 3);
        int after = ladder.run(3);

        //then
        Assertions.assertThat(before).isEqualTo(3);
        Assertions.assertThat(after).isEqualTo(4);
    }
}