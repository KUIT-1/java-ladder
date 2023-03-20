package ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RowTest {

    @Test
    @DisplayName("Line 이 올바르게 그려지는 지 확인")
    void drawLineTest() {
        //when
        Row rows = new Row(10);
        int startPosition = 5;
        int[] row = rows.row;

        //given
        rows.drawLine(startPosition);

        //then
        Assertions.assertThat(row[startPosition]).isEqualTo(Direction.RIGHT.getDirection());
        Assertions.assertThat(row[startPosition + 1]).isEqualTo(Direction.LEFT.getDirection());
    }

    @Test
    @DisplayName("올바르게 다음 Position 을 찾아내는 지 확인")
    void getNextPositionTest() {
        //when
        Row rows = new Row(10);

        // given
        int startPosition = 1;
        rows.drawLine(startPosition);

        // then
        int expectedEndPosition = 2;
        int endPosition = rows.getNextPosition(startPosition);
        Assertions.assertThat(endPosition).isEqualTo(expectedEndPosition);
    }

    @Test
    @DisplayName("양쪽으로 연결된 경우에는 왼쪽으로 간다")
    void getNextPositionTest2() {
        //when
        Row rows = new Row(10);

        // given
        int startPosition = 1;
        rows.drawLine(1);
        rows.drawLine(0);

        // then
        int expectedEndPosition = 0;
        int endPosition = rows.getNextPosition(startPosition);
        Assertions.assertThat(endPosition).isEqualTo(expectedEndPosition);
    }

    @Test
    @DisplayName("아무것도 연결되지 않음을 잘 체크하는지 확인")
    void connectedNothingTest() {
        // when
        Row rows = new Row(10);
        // given
        // Line 을 하나도 그리지 않음

        // then
        for(int pos = 0 ; pos < 10; pos ++){
            Assertions.assertThat(rows.connectedNothing(pos)).isEqualTo(true);
        }
    }

    @Test
    @DisplayName("Left 방향에 경로가 있는지 잘 체크하는 지 확인")
    void connectedLeftTest() {
        // When
        Row rows = new Row(10);

        // given
        rows.drawLine(5);

        // then
        Assertions.assertThat(rows.connectedLeft(6)).isEqualTo(true);
    }

    @Test
    @DisplayName("참여하는 사람 수에 따른 예외처리를 올바르게 하는 지 확인")
    void validateNumberOfPersonTest() {
        assertThrows(IllegalArgumentException.class,
                () -> new Row(-1));
    }

    @Test
    @DisplayName("현재 지점에서 Drawing 이 가능한 지 잘 체크하는 지 확인")
    void validateDrawingPositionTest() {
        // When
        Row rows = new Row(10);

        // given
        int startPosition = 9;

        // then
        assertThrows(IllegalArgumentException.class,
                () -> rows.drawLine(startPosition));
    }

    @Test
    @DisplayName("OutOfBounds Check 를 잘하는 지 확인")
    void validatePositionTest() {
        // When
        Row rows = new Row(10);

        // Given
        int invalidPosition1 = -1;
        int invalidPosition2 = 11;

        assertThrows(IllegalArgumentException.class,
                () -> rows.validatePosition(invalidPosition1));
        assertThrows(IllegalArgumentException.class,
                () -> rows.validatePosition(invalidPosition2));

    }
}