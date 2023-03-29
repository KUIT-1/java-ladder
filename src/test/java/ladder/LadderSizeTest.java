package ladder;

import org.junit.jupiter.api.Test;

import static ladder.LadderSize.createLadderSize;
import static ladder.NaturalNumber.createNaturalNumber;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadderSizeTest {
    @Test
    void getSizeValue() {
        NaturalNumber row = createNaturalNumber(2);
        NaturalNumber numberOfPerson = createNaturalNumber(3);
        LadderSize ladderSize = createLadderSize(row, numberOfPerson);

        assertEquals(2, ladderSize.getRowValue());
        assertEquals(3, ladderSize.getNumberOfPersonValue());
        assertEquals(6, ladderSize.getLadderSize());
    }
}
