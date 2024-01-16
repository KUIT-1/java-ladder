package ladder.domain;

import ladder.domain.wrapper.CurrentPosition;
import ladder.domain.wrapper.Direction;
import ladder.domain.wrapper.LadderNumber;
import ladder.domain.wrapper.NumberOfPerson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RowTest {

    Row row;

    @BeforeEach
    public void reset() {
        row = new Row(NumberOfPerson.of(5));
    }

    @Test
    public void createRow() throws Exception {
        //given
        Row row = new Row(NumberOfPerson.of(5));

        //when
        row.setValue(2, 3);

        //then
        assertEquals(Direction.LEFT.getDirection(), row.getValue(2));
        assertEquals(Direction.RIGHT.getDirection(), row.getValue(3));
    }

    @Test
    public void nextPosition() throws Exception {
        //when
        row.setValue(2, 3);
        LadderNumber ladderNumber = LadderNumber.of(2);
        CurrentPosition currentPosition = CurrentPosition.createCurrentPosition(ladderNumber);

        row.nextPosition(currentPosition);

        //then
        /** currentPosition 초기 x 값은 0임 */
        assertTrue(currentPosition.equal(0, 3));
    }

    @Test
    public void validate() throws Exception {
        //when
        row.setValue(2, 3);
        LadderNumber ladderNumber = LadderNumber.of(10);
        CurrentPosition currentPosition = CurrentPosition.createCurrentPosition(ladderNumber);

        //then
        assertThrows(IllegalArgumentException.class,
                () -> row.nextPosition(currentPosition));
    }
}
