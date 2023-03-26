package ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static ladder.NaturalNumber.*;
import static ladder.Position.createPosition;
import static org.junit.jupiter.api.Assertions.*;

public class LadderTest {

    static Ladder ladder;

    @BeforeEach
    void init(){
        NaturalNumber height = createNaturalNumber(5);
        NaturalNumber numberOfPerson = createNaturalNumber(4);
        ladder = new Ladder(height, numberOfPerson);
    }

    @Test
    @DisplayName("Run : Line x")
    void When_runWithoutLine_Expect_SamePointAsStartPoint(){
        assertEquals(2, ladder.run(createPosition(2)));
    }

    @Test
    @DisplayName("Run : Line 1개 추가 후 Run")
    void When_RunWithLine_Expect_NextPointOfStartPoint(){
        ladder.drawLine(createPosition(2), createPosition(3));
        assertEquals(1, ladder.run(createPosition(1)));
        assertEquals(2, ladder.run(createPosition(2)));
        assertEquals(4, ladder.run(createPosition(3)));
        assertEquals(3, ladder.run(createPosition(4)));
    }

    @Test
    @DisplayName("Run : Line 여러 개 추가 후 Run")
    void When_RunWithLines_Expect_ReturnCorrectPosition(){
        ladder.drawLine(createPosition(1), createPosition(1));
        ladder.drawLine(createPosition(2), createPosition(2));
        ladder.drawLine(createPosition(3), createPosition(3));
        assertEquals(4, ladder.run(createPosition(1)));
        assertEquals(1, ladder.run(createPosition(2)));
        assertEquals(2, ladder.run(createPosition(3)));
        assertEquals(3, ladder.run(createPosition(4)));
    }

    @Test
    @DisplayName("Run : 이어지는 Line 추가 후 Run")
    void When_RunWithConnectLines_Expect_ReturnCorrectPosition(){
        ladder.drawLine(createPosition(1), createPosition(1));
        ladder.drawLine(createPosition(2), createPosition(2));
        ladder.drawLine(createPosition(2), createPosition(3));
        ladder.drawLine(createPosition(3), createPosition(3));
        assertEquals(3, ladder.run(createPosition(1)));
        assertEquals(1, ladder.run(createPosition(2)));
        assertEquals(3, ladder.run(createPosition(3)));
        assertEquals(2, ladder.run(createPosition(4)));
    }

    // 예외처리
    @Test
    @DisplayName("생성자 : 높이/인원수 유효성")
    void When_InvalidArgumentInConstructor_Expect_ThrowException(){
        assertThrows(IllegalArgumentException.class, ()-> new Ladder(createNaturalNumber(0), createNaturalNumber(1)));
        assertThrows(IllegalArgumentException.class, ()-> new Ladder(createNaturalNumber(1), createNaturalNumber(0)));
        assertThrows(IllegalArgumentException.class, ()-> new Ladder(createNaturalNumber(0), createNaturalNumber(0)));
    }
    @Test
    @DisplayName("drawLine : row 값 유효성")
    void When_InvalidRowValueInDrawLine_Expect_ThrowException(){
        assertThrows(IllegalArgumentException.class, ()-> ladder.drawLine(createPosition(-3), createPosition(3)));
        assertThrows(IllegalArgumentException.class, ()-> ladder.drawLine(createPosition(0), createPosition(3)));
        assertThrows(IllegalArgumentException.class, ()-> ladder.drawLine(createPosition(6), createPosition(3)));
    }

    @Test
    @DisplayName("drawLine : col 값 유효성")
    void When_InvalidColValueInDrawLine_Expect_ThrowException(){
        assertThrows(IllegalArgumentException.class, ()-> ladder.drawLine(createPosition(4), createPosition(-1)));
        assertThrows(IllegalArgumentException.class, ()-> ladder.drawLine(createPosition(4), createPosition(0)));
        assertThrows(IllegalArgumentException.class, ()-> ladder.drawLine(createPosition(4), createPosition(4)));
        assertThrows(IllegalArgumentException.class, ()-> ladder.drawLine(createPosition(4), createPosition(7)));
    }

    @Test
    @DisplayName("run : 시작점 유효성")
    void When_InvalidStartPointInRun_Expect_ThrowException(){
        assertThrows(IllegalArgumentException.class, ()-> ladder.run(createPosition(-1)));
        assertEquals(4, ladder.run(createPosition(4)));
        assertThrows(IllegalArgumentException.class, ()-> ladder.run(createPosition(7)));
    }
}