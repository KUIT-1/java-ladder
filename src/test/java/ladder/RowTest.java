package ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static ladder.NaturalNumber.createNaturalNumber;
import static ladder.Position.createPosition;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RowTest {
    Row row;

    @BeforeEach
    void init() {
        NaturalNumber numberOfPerson = createNaturalNumber(3);
        row = new Row(numberOfPerson);
    }

    @Test
    void nextPosition() {
        row.drawLine(createPosition(1)); // 1과 2 사이에 라인 생성

        Position position = createPosition(1);
        row.nextPosition(position);

        assertEquals(2, position.getPosition());
    }

    @Test
    @DisplayName("사다리 참여자 수가 1보다 작을 때 에러")
    void outOfRangeNumberOfPerson() {
        assertThrows(IllegalArgumentException.class,() -> createNaturalNumber(0));
        assertThrows(IllegalArgumentException.class,() -> createNaturalNumber(-1));
    }

    @Test
    @DisplayName("사다리 범위를 벗어난 라인 생성 시 에러")
    void outOfRangeLine() {
        assertThrows(IllegalArgumentException.class,() -> row.drawLine(createPosition(0)));
        assertThrows(IllegalArgumentException.class,() -> row.drawLine(createPosition(3)));
    }

    @Test
    @DisplayName("이미 라인이 생성된 줄에 라인 생성 시 에러")
    void alreadyHasLine() {
        row.drawLine(createPosition(1));

        assertThrows(IllegalArgumentException.class,() -> row.drawLine(createPosition(1)));
        assertThrows(IllegalArgumentException.class,() -> row.drawLine(createPosition(2)));
    }
}
