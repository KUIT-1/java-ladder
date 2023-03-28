package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RowTest {

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