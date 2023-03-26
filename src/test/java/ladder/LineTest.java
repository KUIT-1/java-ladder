package ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static ladder.Direction.*;
import static ladder.NaturalNumber.createNaturalNumber;
import static ladder.Position.createPosition;
import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    static LineManager lineManager;

    @BeforeEach
    void init(){
        NaturalNumber height = createNaturalNumber(5);
        NaturalNumber numberOfPerson = createNaturalNumber(4);
        lineManager = new LineManager(height, numberOfPerson);
    }

    @Test
    @DisplayName("LineByPosition 생성자 테스트")
    void When_createLineByPosition_Expect_LeftAndRightAreFalse(){
        LineByPosition lineByPosition = new LineByPosition();
        try {
            Field leftField = lineByPosition.getClass().getDeclaredField("left");
            leftField.setAccessible(true);
            boolean left = (boolean)leftField.get(lineByPosition);
            assertEquals(false, left);

            Field rightField = lineByPosition.getClass().getDeclaredField("left");
            rightField.setAccessible(true);
            boolean right = (boolean)rightField.get(lineByPosition);
            assertEquals(false, right);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("addLinetoLeft 테스트")
    void When_addLinetoLeft_Expect_LeftIsTrue(){
        LineByPosition lineByPosition = new LineByPosition();
        try {
            Field field = lineByPosition.getClass().getDeclaredField("left");
            field.setAccessible(true);

            lineByPosition.addLinetoLeft();
            boolean left = (boolean)field.get(lineByPosition);
            assertEquals(true, left);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    @Test
    @DisplayName("addLinetoRight 테스트")
    void When_addLinetoRight_Expect_RightIsTrue(){
        LineByPosition lineByPosition = new LineByPosition();
        try {
            Field field = lineByPosition.getClass().getDeclaredField("right");
            field.setAccessible(true);

            lineByPosition.addLinetoRight();
            boolean right = (boolean)field.get(lineByPosition);
            assertEquals(true, right);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    @Test
    @DisplayName("drawLine 테스트 : 해당 좌표의 right == true, 오른쪽 좌표의 left == true")
    void When_drawLine_Expect_RightOfColIsTrueAndLeftOfNextColIsTrue(){
        final int row = 2;
        final int col = 2;
        lineManager.drawLine(createPosition(row), createPosition(col));
        try {
            Field lineByRowsField = lineManager.getClass().getDeclaredField("lineByRows");
            lineByRowsField.setAccessible(true);
            LineByRow[] lineByRows = (LineByRow[])lineByRowsField.get(lineManager);


            Field lineByPositionsField = lineByRows[row].getClass().getDeclaredField("lineByPositions");
            lineByPositionsField.setAccessible(true);
            LineByPosition[] lineByPositions = (LineByPosition[])lineByPositionsField.get(lineByRows[2]);


            Field rightField = lineByPositions[col].getClass().getDeclaredField("right");
            rightField.setAccessible(true);
            boolean right = (boolean)rightField.get(lineByPositions[col]);
            assertEquals(true, right);


            Field leftField = lineByPositions[col + 1].getClass().getDeclaredField("left");
            leftField.setAccessible(true);
            boolean left = (boolean)leftField.get(lineByPositions[col + 1]);
            assertEquals(true, left);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    @Test
    @DisplayName("checkDirection : 하향 중에 line 만난 경우")
    void When_LastMoveIsDownward_Expect_ReturnStateAfterMove(){
        lineManager.drawLine(createPosition(1), createPosition(2));
        assertEquals(RIGHT, lineManager.nextDirection(createPosition(1), createPosition(2), DOWN));
        assertEquals(LEFT, lineManager.nextDirection(createPosition(1), createPosition(3), DOWN));
    }

    @Test
    @DisplayName("checkDirection : 하향 중 & 좌우에 line이 존재")
    void When_LastMoveIsDownwardAndLineOnBothSide_Expect_ReturnStateAfterMove(){
        lineManager.drawLine(createPosition(1), createPosition(2));
        lineManager.drawLine(createPosition(1), createPosition(1));
        assertEquals(RIGHT, lineManager.nextDirection(createPosition(1), createPosition(2), DOWN));
    }

    @Test
    @DisplayName("checkDirection : 좌향 중")
    void When_LastMoveIsLeftward_Expect_ReturnStateAfterMove(){
        lineManager.drawLine(createPosition(1), createPosition(2));
        assertEquals(DOWN, lineManager.nextDirection(createPosition(1), createPosition(2), LEFT));
        assertEquals(LEFT, lineManager.nextDirection(createPosition(1), createPosition(3), LEFT));
    }

    @Test
    @DisplayName("checkDirection : 우향 중")
    void When_LastMoveIsRightward_Expect_ReturnStateAfterMove(){
        lineManager.drawLine(createPosition(1), createPosition(2));
        assertEquals(RIGHT, lineManager.nextDirection(createPosition(1), createPosition(2), RIGHT));
        assertEquals(DOWN, lineManager.nextDirection(createPosition(1), createPosition(3), RIGHT));
    }


    @Test
    @DisplayName("drawLine : row 값 유효성")
    void When_InvalidRowValueInDrawLine_Expect_ThrowException(){
        assertThrows(IllegalArgumentException.class, ()-> lineManager.drawLine(createPosition(-3), createPosition(3)));
        assertThrows(IllegalArgumentException.class, ()-> lineManager.drawLine(createPosition(0), createPosition(3)));
        assertThrows(IllegalArgumentException.class, ()-> lineManager.drawLine(createPosition(6), createPosition(3)));
    }

    @Test
    @DisplayName("drawLine : col 값 유효성")
    void When_InvalidColValueInDrawLine_Expect_ThrowException(){
        assertThrows(IllegalArgumentException.class, ()-> lineManager.drawLine(createPosition(4), createPosition(-1)));
        assertThrows(IllegalArgumentException.class, ()-> lineManager.drawLine(createPosition(4), createPosition(0)));
        assertThrows(IllegalArgumentException.class, ()-> lineManager.drawLine(createPosition(4), createPosition(4)));
        assertThrows(IllegalArgumentException.class, ()-> lineManager.drawLine(createPosition(4), createPosition(7)));
    }

    @Test
    @DisplayName("validateStartPoint : 시작점 유효성")
    void When_InvalidStartPointInRun_Expect_ThrowException(){
        assertThrows(IllegalArgumentException.class, ()-> lineManager.validateStartPoint(createPosition(-1)));
        assertThrows(IllegalArgumentException.class, ()-> lineManager.validateStartPoint(createPosition(7)));
    }

}