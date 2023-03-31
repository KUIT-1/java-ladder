package ladder;

import ladder.creator.GeneralLadderCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static ladder.LadderPosition.createLadderPosition;
import static ladder.NaturalNumber.createNaturalNumber;
import static ladder.Position.createPosition;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CreatorTest {
    @Test
    @DisplayName("사다리 길이가 0")
    public void CreatorTest1() {
        assertThrows(IllegalArgumentException.class, () -> LadderSize.createLadderSize(createNaturalNumber(0), createNaturalNumber(3)));
        System.out.println();
    }

    @Test
    @DisplayName("사다리 탈 수 있는 사람이 0명")
    public void CreatorTest2() {
        assertThrows(IllegalArgumentException.class, () -> LadderSize.createLadderSize(createNaturalNumber(4), createNaturalNumber(0)));
        System.out.println();
    }

    @Test
    @DisplayName("사다리 선 그릴 수 있는 범위 벗어날 때")
    public void CreatorTest3() {
        LadderSize ladderSize = LadderSize.createLadderSize(createNaturalNumber(3), createNaturalNumber(5));
        LadderGame ladderGame = LadderGameFactory.createLadderGame(ladderSize);

        assertThrows(IllegalArgumentException.class, () -> ladderGame.drawLine(createLadderPosition(createPosition(0), createPosition(0))));
        assertThrows(IllegalArgumentException.class, () -> ladderGame.drawLine(createLadderPosition(createPosition(0), createPosition(3))));
        assertThrows(IllegalArgumentException.class, () -> ladderGame.drawLine(createLadderPosition(createPosition(-1), createPosition(-2))));

    }
}
