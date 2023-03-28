package ladder;

import ladder.creator.LadderCreator;
import ladder.creator.LadderRandomCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static ladder.NaturalNumber.createNaturalNumber;
import static ladder.Position.createPosition;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadderTest {
    @Test
    @DisplayName("run 실행 확인")
    void runSuccessWhenFourRowFourColFourLine() {
        //when
        NaturalNumber numberOfPerson = createNaturalNumber(4);
        NaturalNumber row = createNaturalNumber(4);
        LadderCreator ladderCreator = new LadderCreator(row, numberOfPerson);
        LadderGame ladderGame = new LadderGame(ladderCreator);

        //given
        ladderCreator.drawLine(createPosition(0), createPosition(1));
        ladderCreator.drawLine(createPosition(1),createPosition(0));
        ladderCreator.drawLine(createPosition(2),createPosition(2));
        ladderCreator.drawLine(createPosition(3),createPosition(0));

        Position nthOfPerson = createPosition(0);
        //then
        assertEquals(0,ladderGame.run(nthOfPerson));

        nthOfPerson = createPosition(3);

        assertEquals(2,ladderGame.run(nthOfPerson));
    }

    @Test
    void runPrintLadder(){
        //when
        NaturalNumber numberOfPerson = createNaturalNumber(4);
        NaturalNumber row = createNaturalNumber(4);
        LadderCreator ladderCreator = new LadderCreator(row, numberOfPerson);
        LadderGame ladderGame = new LadderGame(ladderCreator);

        //given
        ladderCreator.drawLine(createPosition(0), createPosition(1));
        ladderCreator.drawLine(createPosition(1),createPosition(0));
        ladderCreator.drawLine(createPosition(2),createPosition(2));
        ladderCreator.drawLine(createPosition(3),createPosition(0));

        ladderGame.runWithPrint(createPosition(0));
    }

    @Test
    void runRandomLadder(){
        //when
        NaturalNumber numberOfPerson = createNaturalNumber(4);
        NaturalNumber row = createNaturalNumber(4);
        LadderRandomCreator ladderCreator = new LadderRandomCreator(row, numberOfPerson);

    }

}