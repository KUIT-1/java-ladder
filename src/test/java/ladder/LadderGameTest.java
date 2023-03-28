package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static ladder.Position.createPosition;
import static org.junit.jupiter.api.Assertions.*;

public class LadderGameTest {
    LadderGame ladderGame;

    @Test
    @DisplayName("사다리의 높이가 1 인 경우")
    public void noLineTest() {
        // when
        ladderGame = new LadderGame(NaturalNumber.createNaturalNumber(1), NaturalNumber.createNaturalNumber(10));
        // given
        int[] startPositionList = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        // then
        for (int j : startPositionList) {
            Position result = ladderGame.run(createPosition(j));
            assertEquals(result.getPosition(), j);
        }
    }

    @Test
    @DisplayName("Run Test #case 1")
    public void Testcase1() {
        // when
        ladderGame = new LadderGame(NaturalNumber.createNaturalNumber(5), NaturalNumber.createNaturalNumber(5));
        // given
        ladderGame.drawLine(createPosition(0), createPosition(0));
        // then
        int startPosition = 0;
        Position result = ladderGame.run(createPosition(startPosition));
        assertEquals(1, result.getPosition());
    }

    @Test
    @DisplayName("Run Test #case 2")
    public void Testcase2() {
        // when
        ladderGame = new LadderGame(NaturalNumber.createNaturalNumber(5), NaturalNumber.createNaturalNumber(5));
        // given
        ladderGame.drawLine(createPosition(0), createPosition(0));
        ladderGame.drawLine(createPosition(1), createPosition(1));
        ladderGame.drawLine(createPosition(2), createPosition(2));
        ladderGame.drawLine(createPosition(3), createPosition(3));
        // then
        int startPosition = 0;
        Position result = ladderGame.run(createPosition(startPosition));
        assertEquals(4, result.getPosition());
    }

    @Test
    @DisplayName("Line Drawing Test")
    void drawLine() {
        // when
        ladderGame = new LadderGame(NaturalNumber.createNaturalNumber(5), NaturalNumber.createNaturalNumber(10));

        //given
        Position before = ladderGame.run(createPosition(3));
        ladderGame.drawLine(createPosition(3), createPosition(3));
        Position after = ladderGame.run(createPosition(3));

        //then
        assertEquals(3, before.getPosition());
        assertEquals(4, after.getPosition());
    }
}