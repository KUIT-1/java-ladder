package ladder.domain;

import ladder.domain.creator.LadderCreator;
import ladder.domain.wrapper.LadderNumber;
import ladder.domain.wrapper.NumberOfPerson;
import ladder.domain.wrapper.NumberOfRow;
import ladder.factory.LadderFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadderRunnerTest {

    @Test
    public void SelfLadderRunner() throws Exception {
        //given
        LadderCreator selfLadderCreator =
                LadderFactory.createSelfLadderCreator(4, 5);

        LadderRunner ladderRunner = LadderFactory.createLadderRunner(selfLadderCreator);

        //when
        selfLadderCreator.drawLine(1, 1, 2);
        selfLadderCreator.drawLine(2, 2, 3);

        int result = ladderRunner.run(LadderNumber.createLadderNumber(1));

        //then
        assertEquals(3, result);
    }
}
