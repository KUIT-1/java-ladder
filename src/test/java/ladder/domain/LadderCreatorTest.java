package ladder.domain;

import ladder.domain.creator.LadderCreator;
import ladder.domain.wrapper.NumberOfPerson;
import ladder.domain.wrapper.NumberOfRow;
import ladder.domain.wrapper.Position;
import ladder.factory.LadderFactory;
import ladder.factory.WrapperFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadderCreatorTest {

    @Test
    public void createSelfLadderCreator() throws Exception {
        //given
        LadderCreator selfLadderCreator = LadderFactory.createSelfLadderCreator(
                        NumberOfRow.createNumberOfRow(4), NumberOfPerson.createNumberOfPerson(5));

        //when
        Position position = WrapperFactory.createPosition(selfLadderCreator.getLadder(), 1, 1, 2);
        selfLadderCreator.drawLine(position.getLeftPointXInt(), position.getLeftPointYInt(), position.getRightPointYInt());

        //then
        assertEquals(1, selfLadderCreator.getLadder().getRows()[1].getValue(1));
        assertEquals(-1, selfLadderCreator.getLadder().getRows()[1].getValue(2));

    }

    @Test
    public void creatRandomLadderCreator() throws Exception {
        //given
        LadderCreator randomLadderCreator = LadderFactory.createRandomLadderCreator(
                        NumberOfRow.createNumberOfRow(4), NumberOfPerson.createNumberOfPerson(5));

        //when
        /** RandomPosition과 마찬가지로 예외 발생하지 않으면 통과 */
        randomLadderCreator.drawLine();
    }
}
