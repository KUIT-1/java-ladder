package ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadderSizeTest {

    LadderSize ladderSize;
    int ladderLength;
    int numberOfPerson;
    @BeforeEach
    void beforeTest() {
        ladderLength = 10;
        numberOfPerson = 5;
        ladderSize = LadderSize.createLadderSize(ladderLength,numberOfPerson);
    }
    @Test
    void createLadderSizeTest() {
        assertEquals(LadderSize.class, ladderSize.getClass());
    }

    @Test
    void getNumberOfLineTest() {
        assertEquals((int)(ladderLength * numberOfPerson * 0.3), ladderSize.getNumberOfLine());
    }
}
