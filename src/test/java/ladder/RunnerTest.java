package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static ladder.LadderPosition.createLadderPosition;
import static ladder.NaturalNumber.createNaturalNumber;
import static ladder.Position.createPosition;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RunnerTest {
    @Test
    @DisplayName("사람이 사다리 개수의 범위를 벗어날 때")
    public void CreatorTest4() {
        LadderSize ladderSize = LadderSize.createLadderSize(createNaturalNumber(4), createNaturalNumber(5));
        LadderGame ladderGame = LadderGameFactory.createLadderGame(ladderSize);

        ladderGame.drawLine(createLadderPosition(createPosition(1),createPosition(1)));
        ladderGame.drawLine(createLadderPosition(createPosition(1),createPosition(2)));
        ladderGame.drawLine(createLadderPosition(createPosition(1),createPosition(4)));
        ladderGame.drawLine(createLadderPosition(createPosition(2),createPosition(2)));
        ladderGame.drawLine(createLadderPosition(createPosition(2),createPosition(3)));
        ladderGame.drawLine(createLadderPosition(createPosition(3),createPosition(3)));
        ladderGame.drawLine(createLadderPosition(createPosition(3),createPosition(2)));
        ladderGame.drawLine(createLadderPosition(createPosition(1),createPosition(5)));
        //ladder.print();
        assertThrows(IllegalArgumentException.class, () -> ladderGame.run(createPosition(6)));
        assertThrows(IllegalArgumentException.class, () -> ladderGame.run(createPosition(0)));
        assertThrows(IllegalArgumentException.class, () -> ladderGame.run(createPosition(-1)));
        System.out.println(ladderGame.run(createPosition(1)));
        System.out.println(ladderGame.run(createPosition(2)));
        System.out.println(ladderGame.run(createPosition(3)));
        System.out.println(ladderGame.run(createPosition(4)));
        System.out.println(ladderGame.run(createPosition(5)));
        System.out.println();
    }

}
