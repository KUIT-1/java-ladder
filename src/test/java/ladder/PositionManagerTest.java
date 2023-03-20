package ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionManagerTest {

    static PositionManager positionManager;

    @BeforeEach
    void init(){
        positionManager = new PositionManager(5, 4);
    }

    @Test
    @DisplayName("checkDirection : 하향 중에 line 만난 경우")
    void When_LastMoveIsDownward_Expect_ReturnStateAfterMove(){
        positionManager = new PositionManager(2, 4);
        positionManager.drawLine(1, 2);
        assertEquals(1, positionManager.checkDirection(1, 2, 0));
        assertEquals(-1, positionManager.checkDirection(1, 3, 0));
    }

    @Test
    @DisplayName("checkDirection : 하향 중 & 좌우에 line이 존재")
    void When_LastMoveIsDownwardAndLineOnBothSide_Expect_ReturnStateAfterMove(){
        positionManager = new PositionManager(2, 4);
        positionManager.drawLine(1, 2);
        positionManager.drawLine(1, 1);
        assertEquals(1, positionManager.checkDirection(1, 2, 0));
    }

    @Test
    @DisplayName("checkDirection : 좌향 중")
    void When_LastMoveIsLeftward_Expect_ReturnStateAfterMove(){
        positionManager = new PositionManager(2, 4);
        positionManager.drawLine(1, 2);
        assertEquals(0, positionManager.checkDirection(1, 2, -1));
        assertEquals(-1, positionManager.checkDirection(1, 3, -1));
    }

    @Test
    @DisplayName("checkDirection : 우향 중")
    void When_LastMoveIsRightward_Expect_ReturnStateAfterMove(){
        positionManager = new PositionManager(2, 4);
        positionManager.drawLine(1, 2);
        assertEquals(1, positionManager.checkDirection(1, 2, 1));
        assertEquals(0, positionManager.checkDirection(1, 3, 1));
    }


    @Test
    @DisplayName("drawLine : row 값 유효성")
    void When_InvalidRowValueInDrawLine_Expect_ThrowException(){
        assertThrows(IllegalArgumentException.class, ()-> positionManager.drawLine(-3, 3));
        assertThrows(IllegalArgumentException.class, ()-> positionManager.drawLine(0, 3));
        assertThrows(IllegalArgumentException.class, ()-> positionManager.drawLine(6, 3));
    }

    @Test
    @DisplayName("drawLine : col 값 유효성")
    void When_InvalidColValueInDrawLine_Expect_ThrowException(){
        assertThrows(IllegalArgumentException.class, ()-> positionManager.drawLine(4, -1));
        assertThrows(IllegalArgumentException.class, ()-> positionManager.drawLine(4, 0));
        assertThrows(IllegalArgumentException.class, ()-> positionManager.drawLine(4, 4));
        assertThrows(IllegalArgumentException.class, ()-> positionManager.drawLine(4, 7));
    }

    @Test
    @DisplayName("validateStartPoint : 시작점 유효성")
    void When_InvalidStartPointInRun_Expect_ThrowException(){
        assertThrows(IllegalArgumentException.class, ()-> positionManager.validateStartPoint(-1));
        assertThrows(IllegalArgumentException.class, ()-> positionManager.validateStartPoint(7));
    }

}