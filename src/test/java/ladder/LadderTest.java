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
    @DisplayName("Run : Line x")
    void When_runWithoutLine_Expect_SamePointAsStartPoint(){
        assertEquals(2, ladder.run(2));
    }

    @Test
    @DisplayName("Run : Line 1개 추가 후 Run")
    void When_runWithLine_Expect_NextPointOfStartPoint(){
        ladder.drawLine(2, 3);
        assertEquals(1, ladder.run(1));
        assertEquals(2, ladder.run(2));
        assertEquals(4, ladder.run(3));
        assertEquals(3, ladder.run(4));
    }

    @Test
    @DisplayName("Run : Line 여러 개 추가 후 Run")
    void When_runWithLines_Expect_ReturnCorrectPosition(){
        ladder.drawLine(1, 1);
        ladder.drawLine(2, 2);
        ladder.drawLine(2, 3);
        ladder.drawLine(3, 3);
        assertEquals(3, ladder.run(1));
        assertEquals(1, ladder.run(2));
        assertEquals(3, ladder.run(3));
        assertEquals(2, ladder.run(4));
    }

    // 예외처리
    @Test
    @DisplayName("생성자 : 높이/인원수 유효성")
    void When_InvalidArgumentInConstructor_Expect_ThrowException(){
        assertThrows(IllegalArgumentException.class, ()-> new Ladder(0, 1));
        assertThrows(IllegalArgumentException.class, ()-> new Ladder(1, 0));
        assertThrows(IllegalArgumentException.class, ()-> new Ladder(0, 0));
    }
    @Test
    @DisplayName("drawLine : row 값 유효성")
    void When_InvalidRowValueInDrawLine_Expect_ThrowException(){
        assertThrows(IllegalArgumentException.class, ()-> ladder.drawLine(-3, 3));
        assertThrows(IllegalArgumentException.class, ()-> ladder.drawLine(0, 3));
        assertThrows(IllegalArgumentException.class, ()-> ladder.drawLine(6, 3));
    }

    @Test
    @DisplayName("drawLine : col 값 유효성")
    void When_InvalidColValueInDrawLine_Expect_ThrowException(){
        assertThrows(IllegalArgumentException.class, ()-> ladder.drawLine(4, -1));
        assertThrows(IllegalArgumentException.class, ()-> ladder.drawLine(4, 0));
        assertThrows(IllegalArgumentException.class, ()-> ladder.drawLine(4, 4));
        assertThrows(IllegalArgumentException.class, ()-> ladder.drawLine(4, 7));
    }

    @Test
    @DisplayName("run : 시작점 유효성")
    void When_InvalidStartPointInRun_Expect_ThrowException(){
        assertThrows(IllegalArgumentException.class, ()-> ladder.run(-1));
        assertEquals(4, ladder.run(4));
        assertThrows(IllegalArgumentException.class, ()-> ladder.run(7));
    }
}