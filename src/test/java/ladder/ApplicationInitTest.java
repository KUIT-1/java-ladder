package ladder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationInitTest {

    @Test
    public void createLadder() throws Exception {
        //given
        Ladder ladder = ApplicationInit.createLadder(4, 5);

        //then
        assertEquals(4, ladder.getRow());
        assertEquals(5, ladder.getNumberOfPerson());
    }

    @Test
    public void validateLadderException() throws Exception {
        //given
        /** row > 2*/
        assertThrows(IllegalArgumentException.class, () -> ApplicationInit.createLadder(2, 5));
        /** numberOfPerson > 1*/
        assertThrows(IllegalArgumentException.class, () -> ApplicationInit.createLadder(5, 1));
    }

    @Test
    public void createPosition() throws Exception {
        //given
        Ladder ladder = ApplicationInit.createLadder(4, 5);
        Position position = ApplicationInit.createPosition(1, 1, 1, 2);

        //then
        assertEquals(1, position.getLeftPointXInt());
        assertEquals(1, position.getLeftPointYInt());
        assertEquals(1, position.getRightPointXInt());
        assertEquals(2, position.getRightPointYInt());
    }

    @Test
    public void validatePositionException() throws Exception {
        //given
        Ladder ladder = ApplicationInit.createLadder(4, 5);

        //when
        /** Y 좌표값이 numberOfPerson을 넘어선 안됨 */
        assertThrows(IllegalArgumentException.class,
                () -> ApplicationInit.createPosition(1, 10, 1, 11));

        /** X 좌표값이 row을 넘어선 안됨
         *  또한 마지막 row와 같아서도 안됨 */
        assertThrows(IllegalArgumentException.class,
                () -> ApplicationInit.createPosition(10, 1, 10, 2));
//        assertThrows(IllegalArgumentException.class,
//                () -> ApplicationInit.createPosition(1, 1, 1, 2));
        assertThrows(IllegalArgumentException.class,
                () -> ApplicationInit.createPosition(5, 2, 5, 2));

        /** rightPoint.Y > leftPoint.Y*/
        assertThrows(IllegalArgumentException.class,
                () -> ApplicationInit.createPosition(1, 2, 1, 1));
        /** 두 좌표의 Y 값 차가 1이어야 함 */
        assertThrows(IllegalArgumentException.class,
                () -> ApplicationInit.createPosition(1, 1, 1, 3));
        /** 두 좌표의 X 값이 같아야 함 */
        assertThrows(IllegalArgumentException.class,
                () -> ApplicationInit.createPosition(1, 1, 2, 2));
    }
}