package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RowTest {

    @Test
    @DisplayName("Line 이 올바르게 그려지는 지 확인")
    void drawLineTest() {
        //when
        Row rows = new Row(NaturalNumber.createNaturalNumber(10));
        int[] row = rows.row;

        //given
        rows.drawLine(Position.createPosition(5));

        //then
        assertEquals(row[5], Direction.RIGHT.getDirection());
        assertEquals(row[6], Direction.LEFT.getDirection());
    }

    @Test
    @DisplayName("올바르게 다음 Position 을 찾아내는 지 확인")
    void getNextPositionTest() {
        //when
        Row rows = new Row(NaturalNumber.createNaturalNumber(10));

        // given
        Position startPosition = Position.createPosition(1);
        rows.drawLine(Position.createPosition(1));

        // then
        int expectedEndPosition = 2;
        rows.getNextPosition(startPosition);
        assertEquals(expectedEndPosition, startPosition.getPosition());
    }

    @Test
    @DisplayName("아무것도 연결되지 않음을 잘 체크하는지 확인")
    void connectedNothingTest() {
        // when
        Row rows = new Row(NaturalNumber.createNaturalNumber(10));
        // given
        // Line 을 하나도 그리지 않음

        // then
        for(int pos = 0 ; pos < 10; pos ++){
            assertTrue(rows.connectedNothing(Position.createPosition(pos)));
        }
    }

    @Test
    @DisplayName("Left 방향에 경로가 있는지 잘 체크하는 지 확인")
    void connectedLeftTest() {
        // When
        Row rows = new Row(NaturalNumber.createNaturalNumber(10));

        // given
        rows.drawLine(Position.createPosition(5));

        // then
        assertTrue(rows.connectedLeft(Position.createPosition(6)));
    }

    @Test
    @DisplayName("OutOfBounds Check 를 잘하는 지 확인")
    void validatePositionTest() {
        // When
        Row rows = new Row(NaturalNumber.createNaturalNumber(10));

        // Given
        int invalidPosition1 = -1;
        int invalidPosition2 = 11;

        assertThrows(IllegalArgumentException.class,
                () -> rows.validatePosition(invalidPosition1));
        assertThrows(IllegalArgumentException.class,
                () -> rows.validatePosition(invalidPosition2));

    }
}