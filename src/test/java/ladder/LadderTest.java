package ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LadderTest {
    Ladder ladder;

    @Test
    @DisplayName("사다리의 높이가 1 인 경우")
    public void noLineTest() {
        // when
        ladder = Ladder.getInstance(1, 10);
        // given
        int[] startPositionList = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        // then
        for(int i = 0 ; i < startPositionList.length; i++){
            int result = ladder.run(startPositionList[i]);
            Assertions.assertThat(result).isEqualTo(startPositionList[i]);
        }
    }
    @Test
    @DisplayName("유효하지 않은 시작 위치가 주어진 경우")
    public void invalidRow(){
        // when
        ladder = Ladder.getInstance(1, 10);
        // given
        int[] givenPositionList = {-1, 11, 100};
        // then assertThrows(IllegalArgumentException.class,()->ladder.run(nthOfPerson));
        for(int pos : givenPositionList){
            assertThrows(IllegalArgumentException.class,
                    ()->ladder.run(pos));
        }
    }
    @Test
    @DisplayName("잘못된 위치에 Line 을 그리려고 하는 경우")
    public void invalidDraw(){
        // when
        ladder = Ladder.getInstance(5, 5);
        // given
        int row = 4;
        int col = 4;
        // then
        assertThrows(IllegalArgumentException.class,
                ()->ladder.drawLine(row, col));
    }
    @Test
    @DisplayName("Testcase 1")
    public void Testcase1(){
        // when
        ladder = Ladder.getInstance(5, 5);
        // given
        ladder.drawLine(0, 0);
        // then
        int startPosition = 0;
        int result = ladder.run(startPosition);
        Assertions.assertThat(result).isEqualTo(1);
    }
    @Test
    @DisplayName("Testcase 2")
    public void Testcase2(){
        // when
        ladder = Ladder.getInstance(5, 5);
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
}