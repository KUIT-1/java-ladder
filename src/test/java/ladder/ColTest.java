package ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static ladder.PositiveNum.createPositiveNumber;
import static org.junit.jupiter.api.Assertions.*;

public class ColTest {


    Col col;
    // 사다리 길이 : 10
    final static PositiveNum colLength = createPositiveNumber(10);
    @BeforeEach
    void beforeTest() {
        col = new Col(createPositiveNumber(colLength.getNum()));
    }

    @Test
    void checkDirection() {
        // 1번째 위치에서 우측으로
        // 네번째 위치에서 좌측으로
        final int onePosition = 1;
        final int twoPosition = 4;
        col.drawLine(onePosition, Direction.RIGHT);
        col.drawLine(twoPosition, Direction.LEFT);

        //정상실행
        assertEquals(Direction.RIGHT.getNum(), col.checkDirection(onePosition));
        assertEquals(Direction.LEFT.getNum(), col.checkDirection(twoPosition));
        assertEquals(Direction.DOWN.getNum(), col.checkDirection(3));

        //에러
        //checkDirection에 길이를 넘는 값이 들어오는 경우
        assertThrows(IllegalArgumentException.class, () -> col.checkDirection(1000));
    }

    @Test
    void validLineTest() {
        col.drawLine(1,null);
        col.drawLine(2, Direction.LEFT);
        col.drawLine(3, Direction.RIGHT);
        col.drawLine(4, Direction.DOWN);

        assertEquals(true, col.validLine(1));
        assertEquals(false, col.validLine(2));
        assertEquals(false, col.validLine(3));
        assertEquals(true, col.validLine(4));
        assertEquals(true, col.validLine(5));
    }
}
