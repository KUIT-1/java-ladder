package ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static ladder.LadderSize.createLadderSize;
import static ladder.NaturalNumber.createNaturalNumber;
import static ladder.Position.createPosition;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LadderTest {

    LadderGame ladder;

    @BeforeEach
    void init() {
        NaturalNumber row = createNaturalNumber(3);
        NaturalNumber numberOfPerson = createNaturalNumber(3);
        LadderSize ladderSize = createLadderSize(row, numberOfPerson);

        ladder = LadderGameFactory.createLadderGame(ladderSize);
    }

    @Test
    void run() {
        ladder.drawLine(LadderPosition.createLadderPosition(createPosition(1), createPosition(1)));
        ladder.drawLine(LadderPosition.createLadderPosition(createPosition(2), createPosition(2)));
        ladder.drawLine(LadderPosition.createLadderPosition(createPosition(3), createPosition(2)));
        assertEquals(2, ladder.run(createPosition(1)));
        assertEquals(1, ladder.run(createPosition(2)));
        assertEquals(3, ladder.run(createPosition(3)));
    }

    @Test
    @DisplayName("사다리 범위를 벗어난 라인 생성 시 에러")
    void outOfRangeLine() {
        assertThrows(IllegalArgumentException.class,() ->
                ladder.drawLine(LadderPosition.createLadderPosition(createPosition(0), createPosition(2))));
        assertThrows(IllegalArgumentException.class,() ->
                ladder.drawLine(LadderPosition.createLadderPosition(createPosition(4), createPosition(2))));
    }
}