package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RowTest {
    @Test
    @DisplayName("row 생성 유효성 검사")
    void ConstructRowFailWhenWrongValue() {
        //given
        int numberOfPerson = 0;
        //then
        assertThrows(IllegalArgumentException.class,()->new Row(numberOfPerson));

    }

    @Test
    @DisplayName("drawLine의 유효성 검사")
    void drawLineFailWhenWrongValue() {
        //when
        int numberOfPerson = 4;
        Row row = new Row(numberOfPerson);

        //given
        int givenCol_1 = 4;
        //then
        assertThrows(IllegalArgumentException.class,()->row.drawLine(givenCol_1));

        //given
        int givenCol_2 = -1;
        //then
        assertThrows(IllegalArgumentException.class,()->row.drawLine(givenCol_2));
    }

    @Test
    @DisplayName("nextPosition의 유효성 검사")
    void nextPositionFailWhenWrongValue() {
        //when
        int numberOfPerson = 4;
        Row row = new Row(numberOfPerson);

        //given
        int position_1 = 7;
        //then
        assertThrows(IllegalArgumentException.class,()->row.nextPosition(position_1));

        //given
        int position_2 = -1;
        //then
        assertThrows(IllegalArgumentException.class,()->row.nextPosition(position_2));
    }

    @Test
    @DisplayName("nextPosition: 1 -1 1 -1 0")
    void nextPositionSuccessWhenTwoLineFiveCol() {
        //when
        int numberOfPerson = 5;
        Row row = new Row(numberOfPerson);

        //given
        row.drawLine(0);
        row.drawLine(2);

        int position = 0;
        //then
        assertEquals(1,row.nextPosition(position));
        //given
        position = 3;
        //then
        assertEquals(2,row.nextPosition(position));
    }
}
