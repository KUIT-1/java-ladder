package ladder.domain;

import ladder.LadderGame;
import ladder.domain.wrapper.Position;
import ladder.factory.LadderFactory;
import ladder.factory.WrapperFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PositionTest {

    static LadderGame ladderGame;

    @BeforeAll
    static void setLadder() {
        ladderGame = LadderFactory.createLadderGame(LadderFactory.createSelfLadderCreator(4, 5));
    }

    @Test
    public void createPosition() throws Exception {
        //given
        Position position = WrapperFactory.createPosition(ladderGame.getLadder(), 1, 1, 2);

        //then
        assertEquals(1, position.getLeftPointXInt());
        assertEquals(1, position.getLeftPointYInt());
        assertEquals(1, position.getRightPointXInt());
        assertEquals(2, position.getRightPointYInt());
    }

    @Test
    public void validatePositionException() throws Exception {
        //when
        /** Y 좌표값이 numberOfPerson을 넘어선 안됨 */
        assertThrows(IllegalArgumentException.class,
                () -> WrapperFactory.createPosition(ladderGame.getLadder(), 10, 1, 11));

        /** X 좌표값이 row을 넘어선 안됨
         *  또한 마지막 row와 같아서도 안됨 */
        assertThrows(IllegalArgumentException.class,
                () -> WrapperFactory.createPosition(ladderGame.getLadder(), 1, 10, 2));
        assertThrows(IllegalArgumentException.class,
                () -> WrapperFactory.createPosition(ladderGame.getLadder(), 2, 5, 2));

        /** rightPoint.Y > leftPoint.Y*/
        assertThrows(IllegalArgumentException.class,
                () -> WrapperFactory.createPosition(ladderGame.getLadder(), 2, 1, 1));
        /** 두 좌표의 Y 값 차가 1이어야 함 */
        assertThrows(IllegalArgumentException.class,
                () -> WrapperFactory.createPosition(ladderGame.getLadder(), 1, 1, 3));
    }
}