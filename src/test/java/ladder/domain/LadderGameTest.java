package ladder.domain;

import ladder.LadderGame;
import ladder.domain.creator.RandomLadderCreator;
import ladder.domain.wrapper.LadderNumber;
import ladder.domain.wrapper.Position;
import ladder.factory.LadderFactory;
import ladder.factory.WrapperFactory;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadderGameTest {

    static LadderGame ladderGame;
    static Position position;

    @BeforeEach
    void reset() {
        ladderGame = LadderFactory.createLadderGame(4, 5);
    }

    @Test
    public void drawLineTest() throws Exception {

        Assumptions.assumeTrue(!(ladderGame.getLadderCreator() instanceof RandomLadderCreator),
                "RandomLadderCreator 가 사용된 경우 테스트 불가. LadderFactory 확인 요망.");

        //given
        position = WrapperFactory.createPosition(ladderGame.getLadder(), 1, 1, 2);

        //when
        ladderGame.getLadderCreator().drawLine(position.getLeftPointXInt(), position.getLeftPointYInt(), position.getRightPointYInt());

        //then
        assertEquals(1, ladderGame.getLadder().getRows()[1].getValue(1));
        assertEquals(-1, ladderGame.getLadder().getRows()[1].getValue(2));
    }

    @Test
    public void runTest() throws Exception {
        //given
        position = WrapperFactory.createPosition(ladderGame.getLadder(), 1, 1, 2);
        ladderGame.getLadderCreator().drawLine(position.getLeftPointXInt(), position.getLeftPointYInt(), position.getRightPointYInt());

        position = WrapperFactory.createPosition(ladderGame.getLadder(), 2, 2, 3);
        ladderGame.getLadderCreator().drawLine(position.getLeftPointXInt(), position.getLeftPointYInt(), position.getRightPointYInt());

        //when
        int result = ladderGame.run(LadderNumber.createLadderNumber(1));

        //then
        assertEquals(3, result);
    }
}