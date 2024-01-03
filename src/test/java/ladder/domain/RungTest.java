package ladder.domain;

import ladder.domain.wrapper.Rung;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RungTest {

//    static LadderGame ladderGame;
//    static Ladder ladder;
//
//    @BeforeAll
//    static void setLadder() {
//        ladderGame = LadderGameFactory.createLadderGame(LadderGameFactory.createSelfLadderGame(4, 5));
//        ladder = LadderGameFactory.getLadder();
//    }

    @Test
    public void createRung() throws Exception {
        //given
        Rung rung = Rung.of(1, 1, 2);

        //then
        assertEquals(1, rung.getLeftPointXInt());
        assertEquals(1, rung.getLeftPointYInt());
        assertEquals(1, rung.getRightPointXInt());
        assertEquals(2, rung.getRightPointYInt());
    }

}
