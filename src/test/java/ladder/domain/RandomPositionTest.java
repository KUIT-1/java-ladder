package ladder.domain;

import ladder.domain.creator.LadderCreator;
import ladder.domain.creator.RandomPosition;
import ladder.domain.wrapper.NumberOfPerson;
import ladder.domain.wrapper.NumberOfRow;
import ladder.domain.wrapper.Position;
import ladder.factory.LadderFactory;
import org.junit.jupiter.api.Test;

public class RandomPositionTest {

    @Test
    public void creatRandomPosition() throws Exception {
        //given
        LadderCreator selfLadderCreator =
                LadderFactory.createSelfLadderCreator(NumberOfRow.createNumberOfRow(10), NumberOfPerson.createNumberOfPerson(10));
        RandomPosition randomPosition = RandomPosition.createRandomPosition();

        //when
        /** 포지션 생성 시 값 검증이 이루어짐. 즉 예외 발생하지 않으면 테스트 통과 */
        for (int i = 0; i < 33; i++) {
            Position position = randomPosition.getPosition(selfLadderCreator.getLadder());
            selfLadderCreator.drawLine(position.getLeftPointXInt(), position.getLeftPointYInt(), position.getRightPointYInt());
        }
    }
}
