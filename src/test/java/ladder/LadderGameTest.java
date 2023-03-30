package ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static ladder.LadderGameFactory.AutogenerateLadderGame;
import static ladder.LadderGameFactory.CustomizationLadderGame;
import static ladder.NaturalNumber.*;
import static ladder.Position.createPosition;
import static org.junit.jupiter.api.Assertions.*;

public class LadderGameTest {
    LadderGame ladderGame;
    LadderSize ladderSize;
    @BeforeEach
    void init(){
        NaturalNumber height = createNaturalNumber(5);
        NaturalNumber numberOfPerson = createNaturalNumber(4);
        ladderSize = new LadderSize(height, numberOfPerson);
        ladderGame = CustomizationLadderGame(ladderSize);
    }

    @Test
    @DisplayName("GameCreator : 사용자 정의 사다리 게임 테스트")
    void When_CustomizationLadderGame_Expect_ReturnLadderGame(){
        ladderGame = CustomizationLadderGame(ladderSize);
        // 빈사다리이기 때문에 그대로 나옴.
        assertEquals(2, ladderGame.run(createPosition(2)));
    }
    @Test
    @DisplayName("GameCreator : 자동 생성 사다리 게임 테스트")
    void When_AutogenerateLadderGameInit_Expect_ReturnLadderGame(){
        ladderGame = AutogenerateLadderGame(ladderSize);
    }

    @Test
    @DisplayName("Auto - run : 자동 생성 사다리 run 테스트")
    void When_AutoGame_Expect_randomAnswer(){
        ladderGame = AutogenerateLadderGame(ladderSize);
        ladderGame.run(createPosition(2));
    }



    @Test
    @DisplayName("Run : Line x")
    void When_runWithoutLine_Expect_SamePointAsStartPoint(){
        assertEquals(2, ladderGame.run(createPosition(2)));
    }

    @Test
    @DisplayName("Run : Line 1개 추가 후 Run")
    void When_RunWithLine_Expect_NextPointOfStartPoint(){
        ladderGame.drawLine(createPosition(2), createPosition(3));
        assertEquals(1, ladderGame.run(createPosition(1)));
        assertEquals(2, ladderGame.run(createPosition(2)));
        assertEquals(4, ladderGame.run(createPosition(3)));
        assertEquals(3, ladderGame.run(createPosition(4)));
    }

    @Test
    @DisplayName("Run : Line 여러 개 추가 후 Run")
    void When_RunWithLines_Expect_ReturnCorrectPosition(){
        ladderGame.drawLine(createPosition(1), createPosition(1));
        ladderGame.drawLine(createPosition(2), createPosition(2));
        ladderGame.drawLine(createPosition(3), createPosition(3));
        assertEquals(4, ladderGame.run(createPosition(1)));
        assertEquals(1, ladderGame.run(createPosition(2)));
        assertEquals(2, ladderGame.run(createPosition(3)));
        assertEquals(3, ladderGame.run(createPosition(4)));
    }

    @Test
    @DisplayName("Run : 이어지는 Line 추가 후 Run")
    void When_RunWithConnectLines_Expect_ReturnCorrectPosition(){
        ladderGame.drawLine(createPosition(1), createPosition(1));
        ladderGame.drawLine(createPosition(2), createPosition(2));
        ladderGame.drawLine(createPosition(2), createPosition(3));
        ladderGame.drawLine(createPosition(3), createPosition(3));
        assertEquals(3, ladderGame.run(createPosition(1)));
        assertEquals(1, ladderGame.run(createPosition(2)));
        assertEquals(3, ladderGame.run(createPosition(3)));
        assertEquals(2, ladderGame.run(createPosition(4)));
    }

    // 예외처리
    @Test
    @DisplayName("drawLine : row 값 유효성")
    void When_InvalidRowValueInDrawLine_Expect_ThrowException(){
        assertThrows(IllegalArgumentException.class, ()-> ladderGame.drawLine(createPosition(-3), createPosition(3)));
        assertThrows(IllegalArgumentException.class, ()-> ladderGame.drawLine(createPosition(0), createPosition(3)));
        assertThrows(IllegalArgumentException.class, ()-> ladderGame.drawLine(createPosition(6), createPosition(3)));
    }

    @Test
    @DisplayName("drawLine : col 값 유효성")
    void When_InvalidColValueInDrawLine_Expect_ThrowException(){
        assertThrows(IllegalArgumentException.class, ()-> ladderGame.drawLine(createPosition(4), createPosition(-1)));
        assertThrows(IllegalArgumentException.class, ()-> ladderGame.drawLine(createPosition(4), createPosition(0)));
        assertThrows(IllegalArgumentException.class, ()-> ladderGame.drawLine(createPosition(4), createPosition(4)));
        assertThrows(IllegalArgumentException.class, ()-> ladderGame.drawLine(createPosition(4), createPosition(7)));
    }

    @Test
    @DisplayName("run : 시작점 유효성")
    void When_InvalidStartPointInRun_Expect_ThrowException(){
        assertThrows(IllegalArgumentException.class, ()-> ladderGame.run(createPosition(-1)));
        assertEquals(4, ladderGame.run(createPosition(4)));
        assertThrows(IllegalArgumentException.class, ()-> ladderGame.run(createPosition(7)));
    }

}