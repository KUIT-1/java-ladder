package ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static ladder.Position.createPosition;
import static ladder.PositiveNum.createPositiveNumber;
import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    Position position;

    //시작 전, 사다리 5개 중, 두번째 사다리
    @BeforeEach
    void beforeTest() {
        position = createPosition(1,5);
    }


    //사다리 밖으로 안나가는지
    @Test
    void validPosition() {
        //정상 값
        assertDoesNotThrow(() -> position.validPosition(createPositiveNumber(1), createPositiveNumber(5)));

        //전체 사다리 갯수보다 더 큰 요구가 들어오는 경우
        assertThrows(IllegalArgumentException.class,
                () -> position.validPosition(createPositiveNumber(10), createPositiveNumber(5)));

        //경계값 테스트
        assertThrows(IllegalArgumentException.class,
                ()-> position.validPosition(createPositiveNumber(5), createPositiveNumber(5)));

        assertDoesNotThrow(()-> position.validPosition(createPositiveNumber(0), createPositiveNumber(5)));
        assertDoesNotThrow(()-> position.validPosition(createPositiveNumber(4), createPositiveNumber(5)));
    }

    //양 끝을 잘 탐지하는지
    @Test
    void detectWall() {
        //정상 값(false가 정상값, 벽에 안부딪힌다는 것)
        assertEquals(false, position.detectWall(Direction.LEFT));
        assertEquals(false, position.detectWall(Direction.RIGHT));
        //DOWN이 들어오는경우(아무 변화 없음)
        assertEquals(false, position.detectWall(Direction.DOWN));

        //0보다 작은데 왼쪽으로 사다리 연결하는 경우
        position = createPosition(0,5);
        assertEquals(true,position.detectWall(Direction.LEFT));
        //전체 사다리 갯수보다 커지는 경우
        position = createPosition(4,5);
        assertEquals(true, position.detectWall(Direction.RIGHT));

    }

    @Test
    public void createPositionTest() {
        assertEquals(Position.class, position.getClass());
    }
}