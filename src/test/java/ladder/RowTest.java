package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static ladder.NaturalNumber.createNaturalNumber;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RowTest {
    @Test
    @DisplayName("row 생성 유효성 검사")
    void ConstructRowFailWhenWrongValue() {
        assertThrows(IllegalArgumentException.class, () -> createNaturalNumber(0));
    }

    @Test
    @DisplayName("drawLine의 유효성 검사")
    void drawLineFailWhenWrongValue() {
        //when
        NaturalNumber numberOfPerson = createNaturalNumber(4);
        Row row = new Row(numberOfPerson);

        //given
        Position givenCol_1 = Position.createPosition(4);
        //then
        assertThrows(IllegalArgumentException.class,()->row.drawLine(givenCol_1));
    }

    @Test
    @DisplayName("nextPosition의 유효성 검사")
    void nextPositionFailWhenWrongValue() {
        //when
        NaturalNumber numberOfPerson = createNaturalNumber(4);
        Row row = new Row(numberOfPerson);

        //given
        Position position_1 = Position.createPosition(7);
        //then
        assertThrows(IllegalArgumentException.class,()->row.nextPosition(position_1));
    }

    @Test
    @DisplayName("nextPosition: 1 -1 1 -1 0")
    void nextPositionSuccessWhenTwoLineFiveCol() {
        //when
        NaturalNumber numberOfPerson = createNaturalNumber(5);
        Row row = new Row(numberOfPerson);

        //given
        row.drawLine(Position.createPosition(0));
        row.drawLine(Position.createPosition(2));

        Position position = Position.createPosition(0);
        row.nextPosition(position);
        //then
        assertEquals(1,position.getPosition());
        //given
        position = Position.createPosition(3);
        row.nextPosition(position);
        //then
        assertEquals(2,position.getPosition());
    }
}
