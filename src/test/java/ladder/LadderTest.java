package ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LadderTest {

    static Ladder ladder;

    @BeforeEach
    void init(){
        ladder = new Ladder(5, 4);
    }

    @Test
    @DisplayName("초기 Run : Line x")
    void runWithoutLine(){
        assertEquals(2, ladder.run(2));
    }


}