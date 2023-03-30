package ladder;

import org.junit.jupiter.api.Test;

import static ladder.NaturalNumber.createNaturalNumber;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadderSizeTest {

    @Test
    void When_getterVariable_Expect_RrturnVariableValue() {
        NaturalNumber height = createNaturalNumber(5);
        NaturalNumber numberOfPerson = createNaturalNumber(4);
        LadderSize ladderSize = new LadderSize(height, numberOfPerson);
        assertEquals(5,ladderSize.getHeight());
        assertEquals(4,ladderSize.getNumberOfPerson());
    }

}
