package ladder.domain;

import ladder.domain.creator.SelfLadderCreator;
import ladder.domain.wrapper.CurrentPosition;
import ladder.domain.wrapper.LadderNumber;
import ladder.domain.wrapper.NumberOfPerson;
import ladder.domain.wrapper.NumberOfRow;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadderRunnerTest {

    @Test
    public void SelfLadderRunner() throws Exception {
        //given

        Ladder ladder = Ladder.of(NumberOfRow.of(4), NumberOfPerson.of(5));
        SelfLadderCreator selfLadderCreator = new SelfLadderCreator(ladder);

        LadderRunner ladderRunner = LadderRunner.of(ladder);

        //when
        selfLadderCreator.drawLine(1, 1, 2);
        selfLadderCreator.drawLine(2, 2, 3);

        LadderNumber ladderNumber = LadderNumber.of(1);
        CurrentPosition currentPosition = CurrentPosition.createCurrentPosition(ladderNumber);
        ladderRunner.run(currentPosition);

        //then
        assertEquals(3, currentPosition.getY());
    }
}
