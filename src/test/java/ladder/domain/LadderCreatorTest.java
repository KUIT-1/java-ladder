package ladder.domain;

import ladder.domain.creator.RandomLadderCreator;
import ladder.domain.creator.SelfLadderCreator;
import ladder.domain.wrapper.NumberOfPerson;
import ladder.domain.wrapper.NumberOfRow;
import ladder.domain.wrapper.Rung;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadderCreatorTest {

    @Test
    public void createSelfLadderCreator() throws Exception {
        //given
        Ladder ladder = Ladder.of(NumberOfRow.of(4), NumberOfPerson.of(5));
        SelfLadderCreator selfLadderCreator = new SelfLadderCreator(ladder);

        //when
        Rung rung = Rung.of(1, 1, 2);
        selfLadderCreator.drawLine(rung.getLeftPointXInt(), rung.getLeftPointYInt(), rung.getRightPointYInt());

        //then
        assertEquals(1, ladder.getRows()[1].getValue(1));
        assertEquals(-1, ladder.getRows()[1].getValue(2));

    }

    @Test
    public void creatRandomLadderCreator() throws Exception {
        //given
        Ladder ladder = Ladder.of(NumberOfRow.of(4), NumberOfPerson.of(5));
        SelfLadderCreator selfLadderCreator = new SelfLadderCreator(ladder);
        RandomLadderCreator randomLadderCreator = new RandomLadderCreator(ladder, selfLadderCreator);

        //when
        /* RandomRung과 마찬가지로 예외 발생하지 않으면 통과 */
        randomLadderCreator.drawLine();
    }
}
