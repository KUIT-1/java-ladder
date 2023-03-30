package ladder;

import ladder.creator.CustomizationLadderCreator;
import ladder.creator.LadderCreator;
import ladder.lineinfo.LineByPosition;
import ladder.lineinfo.LineByRow;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static ladder.NaturalNumber.createNaturalNumber;
import static ladder.Position.createPosition;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LadderCreatorTest {

    LadderGame ladderGame;
    static LadderSize ladderSize;
    LadderCreator ladderCreator;
    @BeforeEach
    void init(){
        NaturalNumber height = createNaturalNumber(5);
        NaturalNumber numberOfPerson = createNaturalNumber(4);
        ladderSize = new LadderSize(height, numberOfPerson);
        ladderCreator = new CustomizationLadderCreator(ladderSize);
    }

    @Test
    @DisplayName("drawLine 테스트 : 해당 좌표의 right == true, 오른쪽 좌표의 left == true")
    void When_drawLine_Expect_RightOfColIsTrueAndLeftOfNextColIsTrue(){
        final int row = 2;
        final int col = 2;
        ladderCreator.drawLine(createPosition(row), createPosition(col));
        try {
            Field lineByRowsField = ladderCreator.getClass().getDeclaredField("lineByRows");
            lineByRowsField.setAccessible(true);
            LineByRow[] lineByRows = (LineByRow[])lineByRowsField.get(ladderCreator);


            Field lineByPositionsField = lineByRows[row].getClass().getDeclaredField("lineByPositions");
            lineByPositionsField.setAccessible(true);
            LineByPosition[] lineByPositions = (LineByPosition[])lineByPositionsField.get(lineByRows[row]);


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
    @DisplayName("drawLine : row 값 유효성")
    void When_InvalidRowValueInDrawLine_Expect_ThrowException(){
        assertThrows(IllegalArgumentException.class, ()->ladderCreator.drawLine(createPosition(-3), createPosition(3)));
        assertThrows(IllegalArgumentException.class, ()->ladderCreator.drawLine(createPosition(0), createPosition(3)));
        assertThrows(IllegalArgumentException.class, ()->ladderCreator.drawLine(createPosition(6), createPosition(3)));
    }

    @Test
    @DisplayName("drawLine : col 값 유효성")
    void When_InvalidColValueInDrawLine_Expect_ThrowException(){
        assertThrows(IllegalArgumentException.class, ()->ladderCreator.drawLine(createPosition(4), createPosition(-1)));
        assertThrows(IllegalArgumentException.class, ()->ladderCreator.drawLine(createPosition(4), createPosition(0)));
        assertThrows(IllegalArgumentException.class, ()->ladderCreator.drawLine(createPosition(4), createPosition(4)));
        assertThrows(IllegalArgumentException.class, ()->ladderCreator.drawLine(createPosition(4), createPosition(7)));
    }



}
