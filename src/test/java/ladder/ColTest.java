package ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class ColTest {


    Col col;
    // 사다리 길이 : 10
    final static PositiveNum colLength = new PositiveNum(10);
    @BeforeEach
    void beforeTest() {
        col = new Col(new PositiveNum(colLength.getNum()));
    }

    @Test
    void checkDirection() {
        // 1번째 위치에서 우측으로
        // 네번째 위치에서 좌측으로
        PositiveNum onePosition = new PositiveNum(1);
        PositiveNum twoPosition = new PositiveNum(4);
        col.drawLine(onePosition, Direction.RIGHT);
        col.drawLine(twoPosition, Direction.LEFT);

        //정상실행
        assertEquals(Direction.RIGHT.getNum(), col.checkDirection(onePosition));
        assertEquals(Direction.LEFT.getNum(), col.checkDirection(twoPosition));
        assertEquals(Direction.DOWN.getNum(), col.checkDirection(new PositiveNum(3)));

        //에러
        //checkDirection에 길이를 넘는 값이 들어오는 경우
        assertThrows(IllegalArgumentException.class, () -> col.checkDirection(new PositiveNum(1000)));
    }
}
