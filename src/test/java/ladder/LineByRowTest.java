package ladder;

import ladder.creator.LadderCreator;
import ladder.lineinfo.LineByPosition;
import ladder.lineinfo.LineByRow;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static ladder.Direction.*;
import static ladder.LadderGameFactory.CustomizationLadderGame;
import static ladder.NaturalNumber.createNaturalNumber;
import static ladder.Position.createPosition;
import static org.junit.jupiter.api.Assertions.*;

class LineByRowTest {

    LadderCreator ladderCreator;
    static LineByRow[] lineByRows;

    @BeforeEach
    void init(){
        NaturalNumber height = createNaturalNumber(5);
        NaturalNumber numberOfPerson = createNaturalNumber(4);
        LadderSize ladderSize = new LadderSize(height, numberOfPerson);

        LadderGame ladderGame = CustomizationLadderGame(ladderSize);

        // private 변수 테스트
        try {
            Field ladderCreatorField = ladderGame.getClass().getDeclaredField("ladderCreator");
            ladderCreatorField.setAccessible(true);
            ladderCreator = (LadderCreator) ladderCreatorField.get(ladderGame);
            lineByRows = ladderCreator.getLineByRows();

        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

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

            Field rightField = lineByPosition.getClass().getDeclaredField("right");
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
    @DisplayName("checkDirection : 하향 중에 line 만난 경우")
    void When_LastMoveIsDownward_Expect_ReturnStateAfterMove(){
        ladderCreator.drawLine(createPosition(1), createPosition(2));
        assertEquals(RIGHT, lineByRows[1].nextDirection(createPosition(2), DOWN));
        assertEquals(LEFT, lineByRows[1].nextDirection(createPosition(3), DOWN));
    }

    @Test
    @DisplayName("checkDirection : 하향 중 & 좌우에 line이 존재")
    void When_LastMoveIsDownwardAndLineOnBothSide_Expect_ReturnStateAfterMove(){
        ladderCreator.drawLine(createPosition(1), createPosition(2));
        ladderCreator.drawLine(createPosition(1), createPosition(1));
        assertEquals(RIGHT, lineByRows[1].nextDirection(createPosition(2), DOWN));
    }

    @Test
    @DisplayName("checkDirection : 좌향 중")
    void When_LastMoveIsLeftward_Expect_ReturnStateAfterMove(){
        ladderCreator.drawLine(createPosition(1), createPosition(2));
        assertEquals(DOWN, lineByRows[1].nextDirection(createPosition(2), LEFT));
        assertEquals(LEFT, lineByRows[1].nextDirection(createPosition(3), LEFT));
    }

    @Test
    @DisplayName("checkDirection : 우향 중")
    void When_LastMoveIsRightward_Expect_ReturnStateAfterMove(){
        ladderCreator.drawLine(createPosition(1), createPosition(2));
        assertEquals(RIGHT, lineByRows[1].nextDirection(createPosition(2), RIGHT));
        assertEquals(DOWN, lineByRows[1].nextDirection(createPosition(3), RIGHT));
    }

}