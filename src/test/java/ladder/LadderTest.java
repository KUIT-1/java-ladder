package ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LadderTest {

    static Ladder ladder;

    @BeforeEach
    void init(){
        ladder = new Ladder(5, 4);
    }

    @Test
    @DisplayName("초기 Run : Line x")
    void runWithoutLine(){
        assertEquals(2, ladder.run(2));
    }

    @Test
    @DisplayName("Line 1개 추가 후 Run (이동 방향 : 좌)")
    void runLeftWithLine(){
        ladder.drawLine(2, 3);
        assertEquals(4, ladder.run(3));
    }

    @Test
    @DisplayName("Line 1개 추가 후 Run (이동 방향 : 우)")
    void runRightWithLine(){
        ladder.drawLine(2, 3);
        assertEquals(3, ladder.run(4));
    }

    @Test
    @DisplayName("Line 여러 개 추가 후 Run")
    void runWithLines(){
        ladder.drawLine(2, 3);
        ladder.drawLine(3, 3);
        assertEquals(4, ladder.run(4));
    }

    // 예외처리
    @Test
    @DisplayName("높이나 인원수를 0 이하의 값으로 생성")
    void wrongCreate(){
        assertThrows(IllegalArgumentException.class, ()-> new Ladder(0, 1));
    }

}