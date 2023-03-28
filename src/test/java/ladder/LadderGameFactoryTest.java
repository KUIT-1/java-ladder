package ladder;

import ladder.creator.LadderNormalCreator;
import ladder.creator.LadderRandomCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LadderGameFactoryTest {





    //Constructor Test/////////////////////////////////////////

    //생성자 생성시 비정상적인 값이 들어오는지?
    @Test
    @DisplayName("constructor : Validation Create Error")
    public void validCreate() {

        //ladderLength 비정상값
        assertThrows(IllegalArgumentException.class, () -> LadderGameFactory.createNormalLadderGame(-1, 10));

        //numberOfPerson 비정상값
        assertThrows(IllegalArgumentException.class, () -> LadderGameFactory.createNormalLadderGame(10, -1));

        //정상값
        assertDoesNotThrow(() -> LadderGameFactory.createNormalLadderGame(1,1));

    }
/////////////////////////////////////////////////////

    @Test
    public void createNormalLadderGameTest() {
        LadderGame lg = LadderGameFactory.createNormalLadderGame(1,1);

        assertEquals(LadderNormalCreator.class, lg.ladderCreator.getClass());
        assertNotEquals(LadderRandomCreator.class, lg.ladderCreator.getClass());
    }
    @Test
    public void createRandomLadderGameTest() {
        LadderGame lg = LadderGameFactory.createRandomLadderGame(1,1);

        assertEquals(LadderRandomCreator.class, lg.ladderCreator.getClass());
        assertNotEquals(LadderNormalCreator.class, lg.ladderCreator.getClass());
    }
}
